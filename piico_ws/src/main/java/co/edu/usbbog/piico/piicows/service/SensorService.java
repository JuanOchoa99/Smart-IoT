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
import co.edu.usbbog.piico.piicows.model.Estacion;
import co.edu.usbbog.piico.piicows.model.EstacionDir;
import co.edu.usbbog.piico.piicows.model.HistoryDataDTO;
import co.edu.usbbog.piico.piicows.model.MapDataDTO;
import co.edu.usbbog.piico.piicows.model.RadialDataDTO;
import co.edu.usbbog.piico.piicows.model.TablaBuscaValor;
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
		System.out.println(variable);
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(variable)) {
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						
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
			if ((hd.getDate().isEqual(dia))){
				if(hd.getEstacion().equals(estacion)) {
					datosDia.add(hd);
				}else {
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
		LocalDate proximaFecha = null;
		Double val = 0.1;
		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (proximaFecha == null) {
				proximaFecha = fecha;
				System.out.println("Hola");
			}
			if (t.size() > 0) {
         	   JSONObject json = new JSONObject();
         	   double max = 0;
               for (int w = 0; w < t.size(); w++) {
                   if (t.get(w) > max) {
                       max = t.get(w);
                   }
               }
               while(!(fecha.equals(proximaFecha))) {
	            	json.put("date", proximaFecha);
                    json.put("price",val);
                    resultado.put(json);
                    proximaFecha = proximaFecha.plusDays(1); 
                    json = new JSONObject();
               }
               //System.out.println("Máximo: " + max);
               json.put("date", fecha);
               json.put("price",max);
               resultado.put(json);	
               proximaFecha = proximaFecha.plusDays(1);  
               
            }
			
		}
		return resultado;
	}
	
	public JSONArray minimo(List<List <HistoryDataDTO>> listas) {
		
		JSONArray resultado = new JSONArray();
		LocalDate proximaFecha = null;
		Double val = 0.1;
		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (proximaFecha == null) {
				proximaFecha = fecha;
				System.out.println("Hola");
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
                while(!(fecha.equals(proximaFecha))) {
	            	json.put("date", proximaFecha);
                    json.put("price",val);
                    resultado.put(json);
                    proximaFecha = proximaFecha.plusDays(1); 
                    json = new JSONObject();
               }
               //System.out.println("Máximo: " + max);
               json.put("date", fecha);
               json.put("price",min);
               resultado.put(json);	
               proximaFecha = proximaFecha.plusDays(1);  
			}
		}
		return resultado;
	}
	public JSONArray promedio(List<List <HistoryDataDTO>> listas) {
		
		JSONArray resultado = new JSONArray();
		LocalDate proximaFecha = null;
		Double val = 0.1;
		for (int i = 0; i < listas.size(); i++) {
			List<HistoryDataDTO> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			LocalDate fecha = null;
			for (HistoryDataDTO valor : listaDia) {
				fecha = valor.getDate();
				t.add(valor.getPrice());
			}
			if (proximaFecha == null) {
				proximaFecha = fecha;
				System.out.println("Hola");
			}
			if (t.size() > 0) {
         	   JSONObject json = new JSONObject();
         	   double promedio = 0;
                for (int w = 0; w < t.size(); w++) {
             	   promedio += t.get(w);
                }
                promedio = promedio/t.size();
                while(!(fecha.equals(proximaFecha))) {
	            	json.put("date", proximaFecha);
                    json.put("price",val);
                    resultado.put(json);
                    proximaFecha = proximaFecha.plusDays(1); 
                    json = new JSONObject();
               }
               //System.out.println("Máximo: " + max);
               json.put("date", fecha);
               json.put("price",promedio);
               resultado.put(json);	
               proximaFecha = proximaFecha.plusDays(1); 
			}
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
	private List<RadialDataDTO> convertJsonArrayRadial(JSONArray valores) {
		List<RadialDataDTO> datos = new ArrayList();
		for (int i = 0; i < valores.length() ; i++) {
			datos.add(new RadialDataDTO().fromJson(valores.getJSONObject(i)));
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
		
		List<MapDataDTO> datos1 = convertJsonArrayMap(valores);
		datos1.sort(Comparator.comparing(MapDataDTO::getDate));
		List<MapDataDTO> datos = datos1;
		datos.sort(Comparator.comparing(MapDataDTO::getEstacion));
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		String estacion = datos.get(0).getEstacion();
		Double lat = datos.get(0).getLan();
		Double lon = datos.get(0).getLon(); 
		System.out.println("Fecha: "+dia);
		System.out.println("Estacion: "+estacion);
		JSONObject json = new JSONObject();
		for (MapDataDTO hd : datos) {
			if ((hd.getEstacion().equals(estacion))){
				if(hd.getDate().isAfter(dia)) {
					lat = hd.getLan();
					lon = hd.getLon();
				}
			}else{
				json.put("title", estacion);
				json.put("latitude", lat);
				json.put("longitude", lon);
				json.put("svgPath", "M9,0C4.029,0,0,4.029,0,9s4.029,9,9,9s9-4.029,9-9S13.971,0,9,0z M9,15.93 c-3.83,0-6.93-3.1-6.93-6.93S5.17,2.07,9,2.07s6.93,3.1,6.93,6.93S12.83,15.93,9,15.93 M12.5,9c0,1.933-1.567,3.5-3.5,3.5S5.5,10.933,5.5,9S7.067,5.5,9,5.5 S12.5,7.067,12.5,9z");
				json.put("zoomLevel", 5);
				json.put("scale", 0.5);
				dia = hd.getDate();
				estacion = hd.getEstacion();
				resultado.put(json);
				json = new JSONObject();
				
			}
		}
		json.put("title", estacion);
		json.put("latitude", lat);
		json.put("longitude", lon);
		json.put("svgPath", "M9,0C4.029,0,0,4.029,0,9s4.029,9,9,9s9-4.029,9-9S13.971,0,9,0z M9,15.93 c-3.83,0-6.93-3.1-6.93-6.93S5.17,2.07,9,2.07s6.93,3.1,6.93,6.93S12.83,15.93,9,15.93 M12.5,9c0,1.933-1.567,3.5-3.5,3.5S5.5,10.933,5.5,9S7.067,5.5,9,5.5 S12.5,7.067,12.5,9z");
		json.put("zoomLevel", 5);
		json.put("scale", 0.5);
		resultado.put(json);
		return resultado;
	}
	private List<TablaBuscaValor> convertJsonArrayTabla(JSONArray valores) {
		List<TablaBuscaValor> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new TablaBuscaValor().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}


	@Override
	public JSONArray buscarValor(LocalDate fecha, String variable, String escala) {
		List<Gateway> gateways = gatewayDAO.findBySensor(variable);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(variable)) {
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(),
								DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						// System.out.println(date);
						if (date.equals(fecha)) {
							json.put("node_id", station.getNode_id());
							json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
							Float numero = Float.parseFloat(dato.getValue());
							json.put("price", numero);
							array.put(json);
						}
					}
				}
			}
		}
		// System.out.println(array.toString()); Creo que no es necesario utilizar el de
		// organizar porque no requerimos un JSON especifico para la tabla
		array = organizarDataTabla(array, escala);
		return array;
	}

	public Double maximoComparativaTabla(List<List<TablaBuscaValor>> listas) {
		double max = 0;
		for (int i = 0; i < listas.size(); i++) {
			List<TablaBuscaValor> listaDia = listas.get(i);
			List<Double> t = new ArrayList<Double>();
			for (TablaBuscaValor valor : listaDia) {
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

	public JSONArray organizarDataTabla(JSONArray valores, String escala) {

		List<TablaBuscaValor> datos1 = convertJsonArrayTabla(valores);
		datos1.sort(Comparator.comparing(TablaBuscaValor::getNode_id));
		JSONArray resultado = new JSONArray();
		String estacion = datos1.get(0).getNode_id();
		Boolean agregado = false;
		List<TablaBuscaValor> datosDia = new ArrayList();
		List<List<TablaBuscaValor>> listas = new ArrayList();
		JSONObject json = new JSONObject();
		for (TablaBuscaValor hd : datos1) {
			if (hd.getNode_id().equals(estacion)) {
				datosDia.add(hd);
			} else {
				agregado = true;
				listas.add(datosDia);
				Double valor = maximoComparativaTabla(listas);
				json.put(estacion, valor);
				estacion = hd.getNode_id();
				datosDia = new ArrayList();
				datosDia.add(hd);
			}
		}
		listas.add(datosDia);
		Double valor = maximoComparativaTabla(listas);
		json.put(estacion, valor);
		resultado.put(json);
		return resultado;
	}

	@Override
	public JSONArray buscarValorActual(String estacion, String variable) {
		List<Gateway> gateways = gatewayDAO.findByNodo(estacion);
		// gateways.stream().forEach(System.out::println);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals(variable)) {
						JSONObject json = new JSONObject();
						LocalDateTime date = LocalDateTime.parse(gateway.getDate(),
								DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						json.put("estacion", station.getNode_id());
						json.put("date", date.toString());
						if(variable.equals("Wind_direction")) {
							json.put("price", dato.getValue());
						}else {
							Float numero = Float.parseFloat(dato.getValue());
							json.put("price", numero);
						}
						array.put(json);
					}
				}
			}
		}
		if(variable.equals("Wind_direction")) {
			array = organizarDataValorActualDireccion(array);
		}else {
			array = organizarDataValorActual(array);
		}
		
		return array;
	}
	
	private JSONArray organizarDataValorActualDireccion(JSONArray valores) {
		List<EstacionDir> datos1 = convertJsonArrayEstacionDir(valores);
		datos1.sort(Comparator.comparing(EstacionDir::getDate));
		List<EstacionDir> datos = datos1;
		datos.sort(Comparator.comparing(EstacionDir::getNode_id));
		JSONArray resultado = new JSONArray();
		LocalDateTime dia = datos.get(0).getDate();
		String estacion = datos.get(0).getNode_id();

		Double valorActual = 0.0;
		if(datos.get(0).getPrice().equals("ESTE")) {
			valorActual = 90.0;
		}else if(datos.get(0).getPrice().equals("SUR-ESTE")) {
			valorActual = 135.0;
		}else if(datos.get(0).getPrice().equals("SUR")) {
			valorActual = 180.0;
		}else if(datos.get(0).getPrice().equals("NOR-ESTE")) {
			valorActual = 45.0;
		}else if(datos.get(0).getPrice().equals("SUR-OESTE")) {
			valorActual = 225.0;
		}else if(datos.get(0).getPrice().equals("NORTE")) {
			valorActual = 360.0;
		}else if(datos.get(0).getPrice().equals("NOR-OESTE")) {
			valorActual = 315.0;
		}else if(datos.get(0).getPrice().equals("OESTE")) {
			valorActual = 270.0;
		}
		JSONObject json = new JSONObject();
		for (EstacionDir hd : datos) {
			if ((hd.getNode_id().equals(estacion))) {
				if (hd.getDate().isAfter(dia)) {
					if(hd.getPrice().equals("ESTE")) {
						valorActual = 90.0;
					}else if(hd.getPrice().equals("SUR-ESTE")) {
						valorActual = 135.0;
					}else if(hd.getPrice().equals("SUR")) {
						valorActual = 180.0;
					}else if(hd.getPrice().equals("NOR-ESTE")) {
						valorActual = 45.0;
					}else if(hd.getPrice().equals("SUR-OESTE")) {
						valorActual = 225.0;
					}else if(hd.getPrice().equals("NORTE")) {
						valorActual = 360.0;
					}else if(hd.getPrice().equals("NOR-OESTE")) {
						valorActual = 315.0;
					}else if(hd.getPrice().equals("OESTE")) {
						valorActual = 270.0;
					}	
					
					estacion = hd.getNode_id();
				}
			} else {
				if(hd.getPrice().equals("ESTE")) {
					valorActual = 90.0;
				}else if(hd.getPrice().equals("SUR-ESTE")) {
					valorActual = 135.0;
				}else if(hd.getPrice().equals("SUR")) {
					valorActual = 180.0;
				}else if(hd.getPrice().equals("NOR-ESTE")) {
					valorActual = 45.0;
				}else if(hd.getPrice().equals("SUR-OESTE")) {
					valorActual = 225.0;
				}else if(hd.getPrice().equals("NORTE")) {
					valorActual = 360.0;
				}else if(hd.getPrice().equals("NOR-OESTE")) {
					valorActual = 315.0;
				}else if(hd.getPrice().equals("OESTE")) {
					valorActual = 270.0;
				}
				json.put("estacion", estacion);
				json.put("valor", valorActual);
				dia = hd.getDate();
				estacion = hd.getNode_id();
				resultado.put(json);
				json = new JSONObject();

			}
		}
		json.put("estacion", estacion);
		json.put("valor", valorActual);
		resultado.put(json);
		json = new JSONObject();
		return resultado;
	}


	private JSONArray organizarDataValorActual(JSONArray valores) {
		List<Estacion> datos1 = convertJsonArrayEstacion(valores);
		datos1.sort(Comparator.comparing(Estacion::getDate));
		List<Estacion> datos = datos1;
		datos.sort(Comparator.comparing(Estacion::getNode_id));
		JSONArray resultado = new JSONArray();
		LocalDateTime dia = datos.get(0).getDate();
		String estacion = datos.get(0).getNode_id();
		Double valorActual = datos.get(0).getPrice();
		JSONObject json = new JSONObject();
		for (Estacion hd : datos) {
			if ((hd.getNode_id().equals(estacion))) {
				if (hd.getDate().isAfter(dia)) {
					valorActual = hd.getPrice();
					estacion = hd.getNode_id();
				}
			} else {
				json.put("estacion", estacion);
				json.put("valor", valorActual);
				dia = hd.getDate();
				estacion = hd.getNode_id();
				valorActual = hd.getPrice();
				resultado.put(json);
				json = new JSONObject();

			}
		}
		json.put("estacion", estacion);
		json.put("valor", valorActual);
		resultado.put(json);
		json = new JSONObject();
		return resultado;
	}

	private List<Estacion> convertJsonArrayEstacion(JSONArray valores) {
		List<Estacion> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new Estacion().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}
	private List<EstacionDir> convertJsonArrayEstacionDir(JSONArray valores) {
		List<EstacionDir> datos = new ArrayList();
		for (int i = 0; i < valores.length(); i++) {
			datos.add(new EstacionDir().fromJson(valores.getJSONObject(i)));
		}
		return datos;
	}
	@Override
	public JSONArray direccionRadial(LocalDate fecha) {
		List<Gateway> gateways = gatewayDAO.find();
		System.out.println(fecha);
		//gateways.stream().forEach(System.out::println);
		JSONArray array = new JSONArray();
		for (Gateway gateway : gateways) {
			List<Station> stations = gateway.getNodos();
			for (Station station : stations) {
				List<Data> datos = station.getSensors();
				for (Data dato : datos) {
					if (dato.getSensor_id().equals("Wind_direction")){
						JSONObject json = new JSONObject();
						LocalDateTime dateTime = LocalDateTime.parse(gateway.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
						LocalDate date = dateTime.toLocalDate();
						if (date.equals(fecha)) {
							json.put("date", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
							//System.out.println(dato.getValue());
							json.put("price",dato.getValue());
							json.put("estacion", station.getNode_id());
							array.put(json);
						}
					
					}
				}
			}
		}
		array = organizarDataRadial(array);
		return array;

	}
	public JSONArray organizarDataRadial(JSONArray valores) {
		
		List<RadialDataDTO> datos = convertJsonArrayRadial(valores);
		datos.sort(Comparator.comparing(RadialDataDTO::getEstacion));
		JSONArray resultado = new JSONArray();
		LocalDate dia = datos.get(0).getDate();
		String estacion = datos.get(0).getEstacion();
		Boolean agregado = false;
		int este=0, surEste=0, sur=0,norEste=0, surOeste=0, norte=0, norOeste=0, oeste=0;
		List<List <RadialDataDTO>> listas = new ArrayList();
		JSONObject json = new JSONObject();
		LocalDate fecha = datos.get(0).getDate();
		Boolean estacion2 = false;
		for (RadialDataDTO hd : datos) {
			if(hd.getEstacion().equals(estacion)) {
				if(hd.getPrice().equals("ESTE")) {
					este+=1;
				}else if(hd.getPrice().equals("SUR-ESTE")) {
					surEste+=1;
				}else if(hd.getPrice().equals("SUR")) {
					sur+=1;
				}else if(hd.getPrice().equals("NOR-ESTE")) {
					norEste+=1;
				}else if(hd.getPrice().equals("SUR-OESTE")) {
					surOeste+=1;
				}else if(hd.getPrice().equals("NORTE")) {
					norte+=1;
				}else if(hd.getPrice().equals("NOR-OESTE")) {
					norOeste+=1;
				}else if(hd.getPrice().equals("OESTE")) {
					oeste+=1;
				}		
			}else {
				
				int[] intArray = new int[]{ norte,norEste,este,surEste,sur,surOeste,oeste,norOeste }; 
				json.put("data", intArray);
				json.put("label", estacion);
				json.put("borderColor", "#458af7");
				json.put("backgroundColor", "#458af7");
				json.put("fill", true);
				resultado.put(json);
				System.out.println(json);
				estacion = hd.getEstacion();
				este=0;
				surEste=0;
				sur=0;
				norEste=0;
				surOeste=0;
				norte=0;
				norOeste=0;
				oeste=0;
				if(hd.getPrice().equals("ESTE")) {
					este+=1;
				}else if(hd.getPrice().equals("SUR-ESTE")) {
					surEste+=1;
				}else if(hd.getPrice().equals("SUR")) {
					sur+=1;
				}else if(hd.getPrice().equals("NOR-ESTE")) {
					norEste+=1;
				}else if(hd.getPrice().equals("SUR-OESTE")) {
					surOeste+=1;
				}else if(hd.getPrice().equals("NORTE")) {
					norte+=1;
				}else if(hd.getPrice().equals("NOR-OESTE")) {
					norOeste+=1;
				}else if(hd.getPrice().equals("OESTE")) {
					oeste+=1;
				}
				json = new JSONObject();
				estacion2 = true;
			}
		}
		int[] intArray = new int[]{ norte,norEste,este,surEste,sur,surOeste,oeste,norOeste }; 
		json.put("data", intArray);
		json.put("label", estacion);
		json.put("borderColor", "#3cba9f");
		json.put("backgroundColor", "#3cba9f");
		json.put("fill", true);
		resultado.put(json);
		System.out.println("Resultado: "+resultado);
		return resultado;
	}
}