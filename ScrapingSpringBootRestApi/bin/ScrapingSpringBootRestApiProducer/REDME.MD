This app is a REST API Producer/Server. The app expose the title, description, link and date of a website from which the data is obtained by scraping

Endpoint:
	http://localhost:8080/SpringBootRestApi/api/scraping/?url=https://www.softzone.es/category/programacion/

JSON Example:

[
	{
        "title": "Muchas veces hemos oído hablar de una API, pero ¿qué es exactamente?",
        "description": "Es probable que hayamos visto muchas veces el término API en las actualizaciones del sistema operativo, el navegador web, o en ocasiones las aplicaciones anuncian nuevas API para los desarrolladores, pero, ¿qué en realidad es una API?",
        "link": "https://www.softzone.es/2018/03/21/que-es-una-api/",
        "date": "... 131 días"
    },
    {
        "title": "Las mejores webs para enseñar lenguajes de programación a los niños (y no tan niños)",
        "description": "Ayer cumplieron 50 años de Logo, una sencilla aplicación diseñada para codificar datos que fue utilizada para enseñar programación a los más jóvenes, y es que la programación informática es cada vez más importante, no solo porque te enseña a pensar y a ver las cosas de otra manera, sino porque todo cada vez está más informatizado, más basado en la nube, y cada vez es más necesario tener al menos unos conceptos básicos de programación para prácticamente cualquier trabajo, incluso fuera de las IT.",
        "link": "https://www.softzone.es/2017/12/05/mejores-webs-ensenar-lenguajes-programacion-ninos/",
        "date": "... 237 días"
    }
]