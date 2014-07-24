class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}


        //custom mapping directly to about.gsp without a controller
        "/about"(view:"about")


		name home: "/"(controller: "question", action: "index")
		"500"(view: '/error')
	}
}
