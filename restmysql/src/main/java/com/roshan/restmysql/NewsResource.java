package com.roshan.restmysql;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("news")
public class NewsResource {

	NewsRepository repo = new NewsRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
	public ArrayList<News> getNews()
	{
		
		
		 return repo.getNews();
		
	}
	
	@GET
	@Path("news/{status}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML} )
	public ArrayList<News> getNews(@PathParam("status") String status){
		
		 return repo.getNews(status);
		
	}
	
	
	
	@POST
	@Path("createnews")
	public News createNews(News n1)
	{
		System.out.println(n1);
		repo.create(n1);
		
		return n1;
	}
	
}
