// CRUD PuertaDeEnlace
	
		@RequestMapping(value = "/guardarPuertaDeEnlace", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String guardarPuertaDeEnlace(@RequestBody Puertadeenlace puertaDeEnlace) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/eliminarPuertaDeEnlace", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String eliminarPuertaDeEnlace(@RequestBody String puertaDeEnlace) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/modificarPuertaDeEnlace", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String modificarRol(@RequestBody Puertadeenlace puertaDeEnlace) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/contarPuertaDeEnlace", method = RequestMethod.GET, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String contarPuertaDeEnlace() {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/buscarPuertaDeEnlace", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String buscarPuertaDeEnlace(@RequestBody String puertaDeEnlace) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/listarPuertaDeEnlace", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String listarPuertaDeEnlace() {
			String mg = "";
			return mg;
		}

// CRUD Log
	
		@RequestMapping(value = "/guardarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String guardarLog(@RequestBody Log log) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/eliminarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String eliminarLog(@RequestBody String log) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/modificarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String modificarLog(@RequestBody Log log) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/contarLog", method = RequestMethod.GET, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String contarLog() {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/buscarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String buscarLog(@RequestBody String log) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/listarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String listarLog() {
			String mg = "";
			return mg;
		}

// CRUD Auth
	
		@RequestMapping(value = "/guardarAuth", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String guardarAuth(@RequestBody Auth auth) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/eliminarAuth", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String eliminarAuth(@RequestBody String auth) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/modificarLog", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String modificarRol(@RequestBody Auth auth) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/contarAuth", method = RequestMethod.GET, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String contarAuth() {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/buscarAuth", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String buscarAuth(@RequestBody String auth) {
			String mg = "";
			return mg;
		}
		
		@RequestMapping(value = "/listarAuth", method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public @ResponseBody String listarAuth() {
			String mg = "";
			return mg;
		}

/**
	 * CRUD Protocolo
	 */
	@RequestMapping(value = "/guardarProtocolo", method = RequestMethod.POST)
	public @ResponseBody String guardarProtocolo(@RequestBody Protocolo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarProtocolo", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarProtocolo(@RequestBody String protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/modificarProtocolo", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarProtocolo(@RequestBody Protocolo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/contarProtocolo", method = RequestMethod.GET)
	public @ResponseBody String contarProtocolo() {
		return null;
	}
	
	@RequestMapping(value = "/buscarProtocolo", method = RequestMethod.GET)
	public @ResponseBody String buscarProtocolo(@RequestBody String protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/listarProtocolos", method = RequestMethod.GET)
	public @ResponseBody String listarProtocolo() {
		return null;
	}
	/**
	 * CRUD Nodo
	 */
	@RequestMapping(value = "/guardarNodo", method = RequestMethod.POST)
	public @ResponseBody String guardarNodo(@RequestBody Nodo protocolo) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarNodo", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarNodo(@RequestBody String nodo) {
		return null;
	}
	
	@RequestMapping(value = "/modificarNodo", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarNodo(@RequestBody Nodo nodo) {
		return null;
	}
	
	@RequestMapping(value = "/contarNodo", method = RequestMethod.GET)
	public @ResponseBody String contarNodo() {
		return null;
	}
	
	@RequestMapping(value = "/buscarNodo", method = RequestMethod.GET)
	public @ResponseBody String buscarNodo(@RequestBody String nodo) {
		return null;
	}
	
	@RequestMapping(value = "/listaNodos", method = RequestMethod.GET)
	public @ResponseBody String listarNodo() {
		return null;
	}
	/**
	 * CRUD Sensor
	 */
	@RequestMapping(value = "/guardarSensor", method = RequestMethod.POST)
	public @ResponseBody String guardarSensor(@RequestBody Sensor sensor) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarSensor", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarSensor(@RequestBody String sensor) {
		return null;
	}
	
	@RequestMapping(value = "/modificarSensor", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarSensor(@RequestBody Sensor sensor) {
		return null;
	}
	
	@RequestMapping(value = "/contarSensor", method = RequestMethod.GET)
	public @ResponseBody String contarSensor() {
		return null;
	}
	
	@RequestMapping(value = "/buscarSensor", method = RequestMethod.GET)
	public @ResponseBody String buscarSensor(@RequestBody String sensor) {
		return null;
	}
	
	@RequestMapping(value = "/listaSensores", method = RequestMethod.GET)
	public @ResponseBody String listarSensor() {
		return null;
	}
	
	/**
	 * CRUD Actuador
	 */
	@RequestMapping(value = "/guardarActuador", method = RequestMethod.POST)
	public @ResponseBody String guardarActuador(@RequestBody Actuador actuador) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarActuador", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarActuador(@RequestBody String actuador) {
		return null;
	}
	
	@RequestMapping(value = "/modificarActuador", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarActuador(@RequestBody Actuador actuador) {
		return null;
	}
	
	@RequestMapping(value = "/contarActuador", method = RequestMethod.GET)
	public @ResponseBody String contarActuador() {
		return null;
	}
	
	@RequestMapping(value = "/buscarActuador", method = RequestMethod.GET)
	public @ResponseBody String buscarActuador(@RequestBody String actuador) {
		return null;
	}
	
	@RequestMapping(value = "/listaActuadores", method = RequestMethod.GET)
	public @ResponseBody String listarActuador() {
		return null;
	}
	
	/**
	 * CRUD Orden
	 */
	@RequestMapping(value = "/guardarOrden", method = RequestMethod.POST)
	public @ResponseBody String guardarOrden(@RequestBody Orden orden) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarOrden", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarOrden(@RequestBody String orden) {
		return null;
	}
	
	@RequestMapping(value = "/modificarOrden", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarOrden(@RequestBody Orden orden) {
		return null;
	}
	
	@RequestMapping(value = "/contarOrden", method = RequestMethod.GET)
	public @ResponseBody String contarOrden() {
		return null;
	}
	
	@RequestMapping(value = "/buscarOrden", method = RequestMethod.GET)
	public @ResponseBody String buscarOrden(@RequestBody String orden) {
		return null;
	}
	
	@RequestMapping(value = "/listaOrdenes", method = RequestMethod.GET)
	public @ResponseBody String listarOrden() {
		return null;
	}
	
	/**
	 * CRUD Ordenactuador
	 */
	@RequestMapping(value = "/guardarOrdenactuador", method = RequestMethod.POST)
	public @ResponseBody String guardarOrdenactuador(@RequestBody Ordenactuador ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/eliminarOrdenactuador", method = RequestMethod.DELETE)
	public @ResponseBody String eliminarOrdenactuador(@RequestBody String ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/modificarOrdenactuador", method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String modificarOrdenactuador(@RequestBody Ordenactuador ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/contarOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String contarOrdenactuador() {
		return null;
	}
	
	@RequestMapping(value = "/buscarOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String buscarOrdenactuador(@RequestBody String ordenActuador) {
		return null;
	}
	
	@RequestMapping(value = "/listaOrdenactuador", method = RequestMethod.GET)
	public @ResponseBody String listarOrdenactuador() {
		return null;
	}
        
