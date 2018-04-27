package uk.ac.le.ac.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.query.Syntax;
import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.util.PrintUtil;


public class SPARQL_DBpedia {
	
	
	public static void main(String[] agrs ){
		
		SPARQL_DBpedia app=new SPARQL_DBpedia();
		
		
		String sparqlQuery1 = "SELECT ?town WHERE {"+
		        "<http://dbpedia.org/resource/Leicester> <http://dbpedia.org/ontology/twinTown> ?town."+
	            "} LIMIT 10";
		
		String sparqlQuery2 = "PREFIX dep:<http://dbpedia.org/resource/>\n"+
		        "PREFIX dbo:<http://dbpedia.org/ontology/>\n"+
				 "SELECT ?town ?country WHERE {\n"+
		        "dep:Leicester dbo:twinTown ?town."+
		        "?town dbo:country ?country."+
	            "} LIMIT 10";
		
		String dbpediaSPARQLendpoint="http://dbpedia.org/sparql";
		
		//query DBpedia
		app.executeSPARQL(sparqlQuery1,dbpediaSPARQLendpoint);
		
		//
		String owlFile="file:///Users/admin/Documents/workspaceSemanticWeb/SW_API/University.owl";
	    String rules="[knowRule:(?a uol:teach ?module)(?b uol:study ?module)->(?a uol:knows ?b)]";   
	    String sparqlQuery3 ="PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>\n"+
	    					"PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"+
	    					"PREFIX uol:<http://www.cs.le.ac.uk/rdf#>\n"+
	    					"PREFIX owl:<http://www.w3.org/2002/07/owl#>\n"+
	    					"SELECT ?x ?y WHERE {?x uol:knows ?y.}";
	    
	    
	    ResultSet rs=app.executeSPARQLwithRules(owlFile, sparqlQuery3, rules);
	    
	    ResultSetFormatter.out(System.out, rs);
	    
	    
	}
	
	

	
	public void executeSPARQL(String sparql, String sparqlEndpoint){
		
		
		String queryString = "SELECT ?town WHERE {"+
		        "<http://dbpedia.org/resource/Leicester> <http://dbpedia.org/ontology/twinTown> ?town."+
	            "} LIMIT 10";
		
		String queryString2 = "PREFIX dep:<http://dbpedia.org/resource/>\n"+
		        "PREFIX dbo:<http://dbpedia.org/ontology/>\n"+
				 "SELECT ?town ?country WHERE {\n"+
		        "dep:Leicester dbo:twinTown ?town."+
		        "?town dbo:country ?country."+
	            "} LIMIT 10";
		
		
		Query query = QueryFactory.create(queryString2);        
        QueryExecution qexec =  QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
        
        try
         {
           ResultSet results = qexec.execSelect();
           
           while(results.hasNext()){
        	   
        	   QuerySolution qs = results.nextSolution();

        	   List<String> columnNames=results.getResultVars();
        	   
        	   for(String heading: columnNames){
        			System.out.print(heading+"\t");
        	   }
        	   
        	   System.out.println("\n");;
        	   
        	   for(int column=0;column<columnNames.size();column++){	 
        		   
        		   
        		   RDFNode node=qs.get(columnNames.get(column));
        		
        		   if(node.isAnon()){
        			   //if this RDFNode is an anonymous resource. 
        			   System.out.print("anonymous:");
        		   }else if(node.isURIResource()){
        			   //if this RDFNode is an URI resource 
        			   System.out.print("URI:");
        		   }else if(node.isLiteral()){
        			   //if this RDFNode is a literal
        			   System.out.print("literal:");
        		   }else if(node.isResource()){
        			   //if this node is a resource
        			   System.out.print("resource:");
        		   }else{
        			   System.out.print("others:");
        			   //else
        		   }
        		   
        		   System.out.print(node.toString()+"\t");
        		   
        	   }
  
        	   	System.out.println("\n");
          		
               }
            }
        finally{
             qexec.close();
         }
        
	}
        
        
        public ResultSet executeSPARQLwithRules(String owlFile, String sparql, String rules){
    		
        	 	
        	 Model model= RDFDataMgr.loadModel(owlFile);
        	
    		
    		Map<String,String> map=model.getNsPrefixMap();
    		
    		ResultSet results=null;
    		
    		int nsSize=map.size();
    		
    		Iterator<Map.Entry<String,String>> i=map.entrySet().iterator();
    		
    		for(int count=0;count<nsSize;count++){
    			 Map.Entry<String,String> entry = (Map.Entry<String,String>)i.next();
    			 String name=(String)entry.getKey();				 
    			 String uri=(String)entry.getValue();
    			if(name!=null && !name.equals("")){
    			    PrintUtil.registerPrefix(name, uri);
    			}else{
    				if(uri!=null){
    				PrintUtil.registerPrefix("uol", uri);
    				}
    			}
    		}

    		if(rules!=null && !rules.equals("")){
    			
    			System.out.println("rules applied");;
    				
    		 Reasoner reasoner = new GenericRuleReasoner(Rule.parseRules(rules));
    		 InfModel infmodel = ModelFactory.createInfModel(reasoner, model);
    			QueryExecution qe = QueryExecutionFactory.create(sparql, Syntax.syntaxARQ, infmodel);
    			results = qe.execSelect();
    		}else{
    			QueryExecution qe = QueryExecutionFactory.create(sparql, Syntax.syntaxARQ, model);		
    			results = qe.execSelect();
    		}	
    		
    		return results;		
 
		
	}
	
	
	
	

}
