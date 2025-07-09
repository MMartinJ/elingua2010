<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
  <head>
   
    <title>My JSP 'index.jsp' starting page</title>
	<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />
  </head>
  <body>
 

	<s:div cssStyle="text-align:center;background-color: #000000;">
        <s:if test="#session.usuari.nomUsuari == 'admin'">
        	<a href="<s:url action="mostrarAdministrar"/>" target="_parent" class="lin"><s:text name="general.administrar" /></a>
        </s:if>
        <s:else>
        	<a href="mostrarPerfilPrivat.action?nomUsuari=<s:property value="#session.usuari.nomUsuari"/>" target="_parent" class="lin"><s:text name="general.perfil" /></a>
        </s:else>
        	
        
        <a href="<s:url action="llistarCursos"/>" target="_parent" class="lin"><s:text name="general.cursos" /></a>
        <s:if test="#session.usuari.tipus == 'collaborador'">
        	<a href="<s:url action="mostrarCrearCurs"/>" target="_parent" class="lin"><s:text name="general.crearNouCurs" /></a>
        </s:if>
        <s:elseif test="#session.usuari.nomUsuari == 'admin'">
        	<a href="<s:url action="mostrarCrearCurs"/>" target="_parent" class="lin"><s:text name="general.crearNouCurs" /></a>
        </s:elseif>
        <a href="<s:url action="mostrarEstadistiques"/>" target="_parent" class="lin"><s:text name="general.estadistiques" /></a>
        <a href="<s:url action="mostrarCercarUsuari"/>" target="_parent" class="lin"><s:text name="general.cercarUsuaris" /></a>
        <a href="<s:url action="llegirMissatge"/>" target="_parent" class="lin"><s:text name="general.missatges" /></a>
        
        
    
    </s:div>
  
  </body>
</html>
