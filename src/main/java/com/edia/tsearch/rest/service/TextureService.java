package com.edia.tsearch.rest.service;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.util.StringUtils;

import com.edia.tsearch.data.domain.Texture;
import com.edia.tsearch.data.util.DbManagerRepository;
import com.edia.tsearch.data.util.IDbRepository;
import com.edia.tsearch.rest.service.exception.ServiceException;
import com.edia.tsearch.rest.service.exceptions.ERROR_CODES;

@Path("/texture")
@Produces(MediaType.APPLICATION_JSON)
public class TextureService {

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	static String content = "Lorem Ipsum is slechts een proeftekst uit het drukkerij- en zetterijwezen. Lorem Ipsum is de standaard proeftekst in deze bedrijfstak sinds de 16e eeuw, toen een onbekende drukker een zethaak met letters nam en ze door elkaar husselde om een font-catalogus te maken. Het heeft niet alleen vijf eeuwen overleefd maar is ook, vrijwel onveranderd, overgenomen in elektronische letterzetting. Het is in de jaren 60 populair geworden met de introductie van Letraset vellen met Lorem Ipsum passages en meer recentelijk door desktop publishing software zoals Aldus PageMaker die versies van Lorem Ipsum bevatten.";

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		IDbRepository dbManager = new DbManagerRepository();

		List<Texture> textures = dbManager.getAll();
		Texture[] textureList = new Texture[textures.size()];
		int counter = 0;
		for (Iterator iterator = textures.iterator(); iterator.hasNext();) {
			Texture texture = (Texture) iterator.next();
			textureList[counter] = texture;
			counter++;
		}
		
		return Response
				.status(200)
				.entity(textureList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Allow-Headers",
						"X-Requested-With, Content-Type, Origin").build();

	}
	
	
	
	@GET
	@Path("/show/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response getById(@PathParam("param") String id){

		IDbRepository dbManager = new DbManagerRepository();
		Texture texture = dbManager.getSelectedId(new Long(id));
		
		return Response
				.status(200)
				.entity(texture)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, OPTIONS, HEAD")
				.header("Access-Control-Allow-Headers",
						"X-Requested-With, Content-Type, Origin").build();

	}

	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response add(@QueryParam(value = "title") String title,
			@QueryParam(value = "content") String content)
			throws ServiceException {

		String result = "";

		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
			System.out.println("both ot them are empty");
			result = new String(ERROR_CODES.ERROR_1.getCode() + ":"
					+ ERROR_CODES.ERROR_1.getDescription());

			return Response
					.status(201)
					.entity(result)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods",
							"OPTIONS, POST, HEAD")
					.header("Access-Control-Allow-Headers",
							"X-Requested-With, Content-Type, Origin").build();

		}

		Texture newTex = new Texture(title, content);
		IDbRepository dbManager = new DbManagerRepository();
		dbManager.saveOrUpdate(newTex);

		return Response
				.status(201)
				.entity(newTex)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
							"OPTIONS, POST, HEAD")
				.header("Access-Control-Allow-Headers",
						"X-Requested-With, Content-Type, Origin").build();

	}

	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response add(@QueryParam(value = "title") String title,
			@QueryParam(value = "content") String content,@QueryParam(value = "id") String id)
			throws ServiceException {

		System.out.println(title);
		System.out.println(content);
		
		String result = "";

		if (StringUtils.isEmpty(title) || StringUtils.isEmpty(content)) {
			System.out.println("both ot them are empty");
			result = new String(ERROR_CODES.ERROR_1.getCode() + ":"
					+ ERROR_CODES.ERROR_1.getDescription());

			return Response
					.status(201)
					.entity(result)
					.header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Methods",
							"OPTIONS, POST, HEAD")
					.header("Access-Control-Allow-Headers",
							"X-Requested-With, Content-Type, Origin").build();

		}

		IDbRepository dbManager = new DbManagerRepository();
		Texture texture = dbManager.getSelectedId(new Long(id));
		
		texture.setContent(content);
		texture.setTitle(title);
		
		dbManager.saveOrUpdate(texture);

		return Response
				.status(201)
				.entity(texture)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
							"OPTIONS, POST, HEAD")
				.header("Access-Control-Allow-Headers",
						"X-Requested-With, Content-Type, Origin").build();

	}
	
}