<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />

</head>
<body>
<s:div cssClass="superCapsalera">
    <s:div cssClass="capsalera">
            
                
                 <span class="capsalera2"><b><s:text name="general.sesioIni" /> <s:property value="#session.usuari.nomUsuari"/></b></span>
                <s:form action="logout" method="post">
                 	<s:submit theme="simple" value="Logout"/>
                 	<s:url id="localeCA" namespace="/" action="mostrarAdministrar.action" >
   							<s:param name="request_locale" >ca</s:param>
   							
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarAdministrar.action" >
   							<s:param name="request_locale" >es</s:param>
   							
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarAdministrar.action" >
   							<s:param name="request_locale" >en</s:param>
   							
						</s:url>
						
						
							
							<s:a href="%{localeCA}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Català |</s:a>
							<s:a href="%{localeES}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Castellano |</s:a>
							<s:a href="%{localeEN}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >English </s:a>
						
                </s:form>
    </s:div>
    
    
    <s:div cssClass="capsalera3"><h1><s:text name="general.titolGeneral" /></h1><img alt="elingua" src="./img/logo1.gif"  /></s:div>
    
    <iframe frameborder="0" style="margin-top:12%;" src ="menu.html" width="100%" height="40px">
        <p><s:text name="general.avisIframe" /></p>
    </iframe>
</s:div>
    <s:div cssClass="contingut" cssStyle="margin-top:15%">
        
		<h2><s:text name="administrar.titol" /></h2>
	
	<fieldset>
	<div>
		<table style="border-color: #000000;border: 1px solid;" width="100%">
			<thead style="color: #FFFFFF; background-color: #000000">
     				<tr>
					
					<td><s:text name="administrar.nomUsu" /></td>
					<td><s:text name="administrar.categoria" /></td>
					<td><s:text name="administrar.modificar" /></td>
					<td><s:text name="administrar.eliminar" /></td>
					
					
		 		</tr>
			</thead>

			<tbody style="color: #FFFFFF; background-color: #FF6633">
			<s:iterator value="usuarisList" >
				<tr>
				
				   <s:iterator status="usuariStatus">
				   			
           				 	<s:if test="#usuariStatus.index == 3">
				   				<td style="text-align: center"><a href="eliminarUsuaris.action?nomUsuari=<s:property />"><s:text name="administrar.eliminar" /></a></td>
				   			</s:if>
				   			<s:elseif test="#usuariStatus.index == 2">
				   				<td style="text-align: center"><a href="mostrarPerfilPrivat.action?nomUsuari=<s:property />"><s:text name="administrar.modificar" /></a></td>
				   			</s:elseif>
				   			<s:else>
           				 		<td><s:property /></td>
           					</s:else>
           				
 			       </s:iterator>
 			       			
			 	</tr>
			</s:iterator>
			
			</tbody>
		</table>
	</div>
	</fieldset>
	<fieldset>
		<div>
			 <s:form action="afegeixIdioma" method="post">
				<s:text name="administrar.afegeixIdi" /> <s:textfield theme="simple" name="nomIdioma" /> 
				<s:fielderror />
			<s:submit key="administrar.afegeix"  cssClass="btn"/>
			</s:form>
		
			<s:select theme="simple" headerKey="-1" list="idiomesLlista" />
		</div>
	</fieldset>
	<fieldset>
		<div>
			 <s:form action="eliminarIdioma" method="post">
				<s:text name="administrar.selecIdiEsborrar" /> 
			<s:submit key="administrar.eliminar" cssClass="btn"/> <s:select theme="simple" name="nomIdiomaEliminar" headerKey="-1" list="idiomesLlista" />
			</s:form>
		</div>
		
	</fieldset>
       
    </s:div>
    <s:div cssClass="superPeu">
        <a href="http://jigsaw.w3.org/css-validator/check/referer">
            <img style="border:0;width:80px;height:23px"
            src="http://jigsaw.w3.org/css-validator/images/vcss"
            alt="CSS Valido" />
        </a>
        <a href="http://validator.w3.org/check?uri=referer">
            <img style="border:0;width:80px;height:23px"
            src="http://www.w3.org/Icons/valid-xhtml10"
            alt="Valid XHTML 1.0 Transitional" />
        </a>
            © Elingua, 2010. Tots els drets reservats.
    </s:div>

</body>
</html>
