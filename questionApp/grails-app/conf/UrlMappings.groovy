class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		name home: "/"(controller: "question", action: "index")
		"500"(view: '/error')
	}
}
