package co.edu.usbbog.piico.piicows.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.IntSummaryStatistics;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.usbbog.piico.piicows.model.HistoryDataDTO;
import co.edu.usbbog.piico.piicows.model.mongo.Data;
import co.edu.usbbog.piico.piicows.model.mongo.Gateway;
import co.edu.usbbog.piico.piicows.model.mongo.Station;
import co.edu.usbbog.piico.piicows.model.mysql.Nodo;
import co.edu.usbbog.piico.piicows.model.mysql.Sensor;
import co.edu.usbbog.piico.piicows.repository.mongo.GatewayDAO;
import co.edu.usbbog.piico.piicows.repository.mysql.ISensorRepository;
import co.edu.usbbog.piico.piicows.repository.mysql.IUsuarioRepository;

@Service
public class SensorService implements ISensorService{
	
	@Autowired
	private ISensorRepository sensorRepo;
	
	
	private GatewayDAO gatewayDAO = new GatewayDAO();

	@Override
	public List<Sensor> sensores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor buscar(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean crear(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean remover(String sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean modificar(Sensor sensor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean asignarNodo(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray history(String stationIn, String variable, String escala) {
		List<Gateway> gateways = gatewayDAO.findByNodo(stationIn);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(variable)) {
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						//System.out.println(date);
						json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
						Float numero = Float.parseFloat(dato.getValue());
						json.put("price",numero);
						array.put(json);		
						
					}
				}
			}
		}
		//System.out.println(array.toString());
		array = organizarData(array, escala);
		return array;

	}
	
	@Override
	public JSONArray comparativa(String sensor, String variable, String escala) {
		List<Gateway> gateways = gatewayDAO.findBySensor(variable);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					JSONObject json = new JSONObject();
					LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
					LocalDate date = dateTime.toLocalDate();
					//System.out.println(date);
					json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					Float numero = Float.parseFloat(dato.getValue());
					json.put("price",numero);
					array.put(json);		
				}
			}
		}
		//System.out.println(array.toString());
		array = organizarData(array, escala);
		return array;

	}
	
	public JSONArray organizarData(JSONArray valores, String escala) {
		
		System.out.println("Valores: "+valores.toString());
		List<HistoryDataDTO> datos = convertJsonArray(valores);
		datos.sort(Comparator.comparing(HistoryDataDTO::getDate));
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		JSONArray valores2 = valores;
		

		List<HistoryDataDTO> datosDia = new ArrayList();
		List<List <HistoryDataDTO>> listas = new ArrayList();
		for (HistoryDataDTO hd : datos) {

			
			if (hd.getDate().isEqual(dia)) {
				datosDia.add(hd);
				System.out.println(hd.toString());
			}else {
				dia = hd.getDate();
				listas.add(datosDia);
				datosDia = new ArrayList();
				datosDia.add(hd);
			}
		}
		listas.add(datosDia);
		if (escala.equals("max")){
			resultado = maximo(listas);
		}else if(escala.equals("min")){
			resultado = minimo(listas);
		}else if(escala.equals("pro")){
			resultado = promedio(listas);
		}
		return resultado;
	}
	
	public JSONArray maximo(List<List <HistoryDataDTO>> listas) {
		
		JSONArray resultado = new JSONArray();

		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (t.size() > 0) {
         	   JSONObject json = new JSONObject();
         	   double max = 0;
               for (int w = 0; w < t.size(); w++) {
                   if (t.get(w) > max) {
                       max = t.get(w);
                   }
               }
               //System.out.println("Máximo: " + max);
               json.put("date", fecha);
               json.put("price",max);
               resultado.put(json);	
            }
			System.out.println(resultado);
		}
		return resultado;
	}
	
	public JSONArray minimo(List<List <HistoryDataDTO>> listas) {
		
		JSONArray resultado = new JSONArray();

		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (t.size() > 0) {
         	   JSONObject json = new JSONObject();
         	   double max = 0;
                for (int w = 0; w < t.size(); w++) {
                    if (t.get(w) > max) {
                        max = t.get(w);
                    }
                }
                double min = max;
                for (int w = 0; w < t.size(); w++) {
                    if (t.get(w) < min) {
                        min = t.get(w);
                    }
                }
                System.out.println("Minimo: " + min);
                json.put("date", fecha);
                json.put("price",min);
                resultado.put(json);	
			}
			System.out.println(resultado);
		}
		return resultado;
	}
	public JSONArray promedio(List<List <HistoryDataDTO>> listas) {
		
		JSONArray resultado = new JSONArray();

		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (t.size() > 0) {
         	   JSONObject json = new JSONObject();
         	   double promedio = 0;
                for (int w = 0; w < t.size(); w++) {
             	   promedio += t.get(w);
                }
                promedio = promedio/t.size();
                json.put("date", fecha);
                json.put("price",promedio);
                resultado.put(json);	
			}
			System.out.println(resultado);
		}
		return resultado;
	}
	
	private List<HistoryDataDTO> convertJsonArray(JSONArray valores) {
		List<HistoryDataDTO> datos = new ArrayList();
		for (int i = 0; i < valores.length() ; i++) {
			datos.add(new HistoryDataDTO().fromJson(valores.getJSONObject(i)));
		}		
		return datos;
	}


	@Override
	public JSONObject comparativa(Sensor sensor, LocalDateTime inicio, LocalDateTime fin, String escala) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject estados(Sensor sensor, LocalDateTime fecha, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	public JSONObject realTime(Sensor sensor, Nodo nodo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
