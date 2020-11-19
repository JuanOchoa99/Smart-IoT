package co.edu.usbbog.piico.piicows.service;



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public JSONArray history(String stationIn, String variable) {
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
						System.out.println(date);
						json.put("date", date);
						Float numero = Float.parseFloat(dato.getValue());
						json.put("price",numero);
						array.put(json);		
						
					}
				}
			}
		}
		System.out.println(array.toString());
		array = promedio(array);
		return array;

	}
	
	public JSONArray Maximo(JSONArray valores) {
		System.out.println("como llega"+valores.toString());
		JSONArray resultado = new JSONArray();
		JSONArray valores2 = valores;
		try {
			for (int i = 0; i < valores.length(); i++) {
					System.out.println("Tamaño: "+valores.length());
				    List<Double> t = new ArrayList<Double>();
			        JSONObject jsonObject = valores.getJSONObject(i);
			        System.out.println("aca entro 1: "+valores);
			        if (jsonObject.has("date")) {
			        	LocalDate fecha = (LocalDate) jsonObject.get("date");
			            for (int j = 0; j < valores2.length(); j++) {

			        		System.out.println("aca entro 2: "+valores2.getJSONObject(j));
					        JSONObject jsonObject2 = valores2.getJSONObject(j);
					        if (jsonObject2.has("date")) {
					        	LocalDate fecha2 = (LocalDate) jsonObject2.get("date");
					            double valor = jsonObject2.getDouble("price");
					            if(fecha2.equals(fecha)) {
					            	System.out.println("aca entro 3: "+valores2.length());
					            	t.add(valor);
					            	valores2.remove(j);
					            }
					        }
			            }
			            if (t.size() > 0) {
			            	   JSONObject json = new JSONObject();
			            	   double max = 0;
			                   for (int w = 0; w < t.size(); w++) {
			                       if (t.get(w) > max) {
			                           max = t.get(w);
			                       }
			                   }
			                   System.out.println("Máximo: " + max);
			                   json.put("date", fecha);
			                   json.put("price",max);
			                   resultado.put(json);	
			            }
			        }
			    
			}
		} catch (JSONException e) {
	        e.printStackTrace();
	    }
		
		return resultado;
	}
	
	public JSONArray Minimo(JSONArray valores) {
		System.out.println("como llega"+valores.toString());
		JSONArray resultado = new JSONArray();
		JSONArray valores2 = valores;
		try {
			for (int i = 0; i < valores.length(); i++) {
					System.out.println("Tamaño: "+valores.length());
				    List<Double> t = new ArrayList<Double>();
			        JSONObject jsonObject = valores.getJSONObject(i);
			        System.out.println("aca entro 1: "+valores);
			        if (jsonObject.has("date")) {
			        	LocalDate fecha = (LocalDate) jsonObject.get("date");
			            for (int j = 0; j < valores2.length(); j++) {

			        		System.out.println("aca entro 2: "+valores2.getJSONObject(j));
					        JSONObject jsonObject2 = valores2.getJSONObject(j);
					        if (jsonObject2.has("date")) {
					        	LocalDate fecha2 = (LocalDate) jsonObject2.get("date");
					            double valor = jsonObject2.getDouble("price");
					            if(fecha2.equals(fecha)) {
					            	System.out.println("aca entro 3: "+valores2.length());
					            	t.add(valor);
					            	valores2.remove(j);
					            }
					        }
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
			        }
			    
			}
		} catch (JSONException e) {
	        e.printStackTrace();
	    }
		
		return resultado;
	}
	public JSONArray promedio(JSONArray valores) {
		System.out.println("como llega"+valores.toString());
		JSONArray resultado = new JSONArray();
		JSONArray valores2 = valores;
		try {
			for (int i = 0; i < valores.length(); i++) {
					System.out.println("Tamaño: "+valores.length());
				    List<Double> t = new ArrayList<Double>();
			        JSONObject jsonObject = valores.getJSONObject(i);
			        System.out.println("aca entro 1: "+valores);
			        if (jsonObject.has("date")) {
			        	LocalDate fecha = (LocalDate) jsonObject.get("date");
			            for (int j = 0; j < valores2.length(); j++) {

			        		System.out.println("aca entro 2: "+valores2.getJSONObject(j));
					        JSONObject jsonObject2 = valores2.getJSONObject(j);
					        if (jsonObject2.has("date")) {
					        	LocalDate fecha2 = (LocalDate) jsonObject2.get("date");
					            double valor = jsonObject2.getDouble("price");
					            if(fecha2.equals(fecha)) {
					            	System.out.println("aca entro 3: "+valores2.length());
					            	t.add(valor);
					            	valores2.remove(j);
					            }
					        }
			            }
			            if (t.size() > 0) {
			            	   JSONObject json = new JSONObject();
			            	   double promedio = 0;
			                   for (int w = 0; w < t.size(); w++) {
			                	   promedio += t.get(w);
			                   }
			                   promedio = promedio/t.size();
			                   System.out.println("Minimo: " + promedio);
			                   json.put("date", fecha);
			                   json.put("price",promedio);
			                   resultado.put(json);	
			            }
			        }
			    
			}
		} catch (JSONException e) {
	        e.printStackTrace();
	    }
		
		return resultado;
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
