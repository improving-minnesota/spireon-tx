class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?" {
			constraints {
				// apply constraints here
			}
		}

		"/showQuestions" (controller: "question", action: "index")
		"/register/index" (controller: "register", action: "registerForm")

		"/"(view: "/index")
		"500"(view: '/error')
	}
}
