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

import co.edu.usbbog.piico.piicows.model.ComparativeDataDTO;
import co.edu.usbbog.piico.piicows.model.HistoryDataDTO;
import co.edu.usbbog.piico.piicows.model.MapDataDTO;
import co.edu.usbbog.piico.piicows.model.mongo.Data;
import co.edu.usbbog.piico.piicows.model.mongo.GPS;
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
	public JSONArray comparativa(String sensor, String escala, String variable, LocalDate fechaIni, LocalDate fechaFin) {
		List<Gateway> gateways = gatewayDAO.find();
		//gateways.stream().forEach(System.out::println);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(sensor)){
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						if ((date.equals(fechaIni) || date.isAfter(fechaIni)) && (date.equals(fechaFin) || date.isBefore(fechaFin))) {
							json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
							//System.out.println(dato.getValue());
							Float numero = Float.parseFloat(dato.getValue());
							json.put("price",numero);
							json.put("estacion", station.getNode_id());
							array.put(json);
						}
					
					}
				}
			}
		}
		array = organizarDataComparativa(array, escala);
		return array;

	}
	
	@Override
	public JSONArray valorActual(String stationIn, String variable) {
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
		return array;

	}
	
	
	public JSONArray organizarDataComparativa(JSONArray valores, String escala) {
		
		System.out.println("Valores: "+valores.toString());
		
		List<ComparativeDataDTO> datos1 = convertJsonArrayComparative(valores);
		datos1.sort(Comparator.comparing(ComparativeDataDTO::getEstacion));
		List<ComparativeDataDTO> datos = datos1;
		datos.sort(Comparator.comparing(ComparativeDataDTO::getDate));
		System.out.println("Datos: "+datos.toString());
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		String estacion = datos.get(0).getEstacion();
		Boolean agregado = false;
		System.out.println("Fecha: "+dia);
		System.out.println("Estacion: "+estacion);
		List<ComparativeDataDTO> datosDia = new ArrayList();
		List<List <ComparativeDataDTO>> listas = new ArrayList();
		JSONObject json = new JSONObject();
		LocalDate fecha = datos.get(0).getDate();
		for (ComparativeDataDTO hd : datos) {
			System.out.println("Fecha: "+hd.getDate());
			System.out.println("Estacion: "+hd.getEstacion());
			if ((hd.getDate().isEqual(dia))){
				System.out.println("Fecha1: "+hd.getDate());
				System.out.println("Estacion1: "+hd.getEstacion());
				if(hd.getEstacion().equals(estacion)) {
					datosDia.add(hd);
					System.out.println("Lo agrego aca");
				}else {
					System.out.println("Fecha2: "+hd.getDate());
					System.out.println("Estacion2: "+hd.getEstacion());
					agregado = true;
					listas.add(datosDia);
					Double valor = null;
					if(escala.equals("Max")) {
						valor = maximoComparativa(listas);
					}else if(escala.equals("Min")) {
						valor = minimoComparativa(listas);
					}else if(escala.equals("Pro")){
						valor = promedioComparativa(listas);
					}
					 
					json.put(estacion, valor);
					if (estacion.equals("estacion_1")){
						json.put("color", "#bfbffd");
					}else if (estacion.equals("estacion_2")){
						json.put("color2", "#7474F0");
					}else {
						json.put("color3", "#952FFE");
					}
					estacion = hd.getEstacion();
					datosDia = new ArrayList();
					datosDia.add(hd);
					System.out.println("Lo agrego aca 2");
					System.out.println("json: "+json);
				}
			}else{
				System.out.println("---------------------------------------------------------");
					listas.add(datosDia);
				Double valor = maximoComparativa(listas);
				json.put(estacion, valor);
				if (estacion.equals("estacion_1")){
					json.put("color", "#bfbffd");
				}else if (estacion.equals("estacion_2")){
					json.put("color2", "#7474F0");
				}else {
					json.put("color3", "#952FFE");
				}
				datosDia = new ArrayList();
				datosDia.add(hd);
				agregado = false;
				dia = hd.getDate();
				estacion = hd.getEstacion();
				json.put("fecha", fecha);
				System.out.println("Json Resultado: "+json);
				resultado.put(json);
				
				fecha = hd.getDate();
				json = new JSONObject();
				
			}
		}
		listas.add(datosDia);
		Double valor = maximoComparativa(listas);
		json.put(estacion, valor);
		datosDia = new ArrayList();
		if (estacion.equals("estacion_1")){
			json.put("color", "#bfbffd");
		}else if (estacion.equals("estacion_2")){
			json.put("color2", "#7474F0");
		}else {
			json.put("color3", "#952FFE");
		}
		json.put("fecha", fecha);
		resultado.put(json);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
	
	public Double maximoComparativa(List<List<ComparativeDataDTO>> listas) {
			double max = 0;
			for (int i = 0; i < listas.size(); i++) {
				List<ComparativeDataDTO> listaDia = listas.get(i);
				List<Double> t = new ArrayList<Double>();
				for (ComparativeDataDTO valor : listaDia) {
					t.add(valor.getPrice());
				}
				if (t.size() > 0) { 
	               for (int w = 0; w < t.size(); w++) {
	                   if (t.get(w) > max) {
	                       max = t.get(w);
	                   }
	               }
	            }
			}

		return max;
	}
	public Double minimoComparativa(List<List<ComparativeDataDTO>> listas) {
		double min = 0;
		for (int i = 0; i < listas.size(); i++) {
			List<ComparativeDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			for (ComparativeDataDTO valor : listaDia) {
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
	                min = max;
	                for (int w = 0; w < t.size(); w++) {
	                    if (t.get(w) < min) {
	                        min = t.get(w);
	                    }
	                }
				}
		}

		return min;
	}
	
	public Double promedioComparativa(List<List<ComparativeDataDTO>> listas) {
  	    double promedio = 0;
		double min = 0;
		for (int i = 0; i < listas.size(); i++) {
			List<ComparativeDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			for (ComparativeDataDTO valor : listaDia) {
				t.add(valor.getPrice());
			}
			if (t.size() > 0) {
	         	   JSONObject json = new JSONObject();

	                for (int w = 0; w < t.size(); w++) {
	             	   promedio += t.get(w);
	                }
	                promedio = promedio/t.size();
				}
		}

		return promedio;
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
			if (hd.getDate().isEqual(dia)){
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
	
	private List<ComparativeDataDTO> convertJsonArrayComparative(JSONArray valores) {
		List<ComparativeDataDTO> datos = new ArrayList();
		for (int i = 0; i < valores.length() ; i++) {
			datos.add(new ComparativeDataDTO().fromJson(valores.getJSONObject(i)));
		}		
		return datos;
	}
	private List<MapDataDTO> convertJsonArrayMap(JSONArray valores) {
		List<MapDataDTO> datos = new ArrayList();
		for (int i = 0; i < valores.length() ; i++) {
			datos.add(new MapDataDTO().fromJson(valores.getJSONObject(i)));
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

	@Override
	public JSONArray buscarValor(LocalDate fecha, String variable, String escala) {
		List<Gateway> gateways = gatewayDAO.findByNodoDate(fecha);
		gateways.stream().forEach((p)-> {
			System.out.println(p);
		});
		return null;
	}
	
	@Override
	public JSONArray mapa(){
		List<Gateway> gateways = gatewayDAO.find();
		//gateways.stream().forEach(System.out::println);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				GPS datos = station.getGps();
				JSONObject json = new JSONObject();
				LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
				LocalDate date = dateTime.toLocalDate();
				json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				//System.out.println(dato.getValue());
				Float lat = datos.getLat();
				Float lon = datos.getLon();
				json.put("lan",lat);
				json.put("lon",lon);
				json.put("estacion", station.getNode_id());
				array.put(json);
			}
		}
		array = organizarDataMapa(array);
		return array;
		
	}

	private JSONArray organizarDataMapa(JSONArray valores) {
		System.out.println("Valores: "+valores.toString());
		
		List<MapDataDTO> datos1 = convertJsonArrayMap(valores);
		datos1.sort(Comparator.comparing(MapDataDTO::getDate));
		List<MapDataDTO> datos = datos1;
		datos.sort(Comparator.comparing(MapDataDTO::getEstacion));
		System.out.println("Datos: "+datos.toString());
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		String estacion = datos.get(0).getEstacion();
		Double lat = datos.get(0).getLan();
		Double lon = datos.get(0).getLon(); 
		System.out.println("Fecha: "+dia);
		System.out.println("Estacion: "+estacion);
		List<ComparativeDataDTO> datosDia = new ArrayList();
		List<List <ComparativeDataDTO>> listas = new ArrayList();
		JSONObject json = new JSONObject();
		for (MapDataDTO hd : datos) {
			System.out.println("Fecha: "+hd.getDate());
			System.out.println("Estacion: "+hd.getEstacion());
			if ((hd.getEstacion().equals(estacion))){
				System.out.println("Fecha1: "+hd.getDate());
				System.out.println("Estacion1: "+hd.getEstacion());
				if(hd.getDate().isAfter(dia)) {
					lat = hd.getLan();
					lon = hd.getLon();
				}
			}else{
				json.put("title", estacion);
				json.put("latitude", lat);
				json.put("longitude", lon);
				dia = hd.getDate();
				estacion = hd.getEstacion();
				System.out.println("Json Resultado: "+json);
				resultado.put(json);
				json = new JSONObject();
				
			}
		}
		json.put("title", estacion);
		json.put("latitude", lat);
		json.put("longitude", lon);
		System.out.println("Json Resultado: "+json);
		resultado.put(json);
		return resultado;
	}

	
}
