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
                 	<s:url id="localeCA" namespace="/" action="llistarCursos.action" >
   							<s:param name="request_locale" >ca</s:param>
   							
						</s:url>
						<s:url id="localeES" namespace="/" action="llistarCursos.action" >
   							<s:param name="request_locale" >es</s:param>
   							
						</s:url>
						<s:url id="localeEN" namespace="/" action="llistarCursos.action" >
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
        <fieldset>
		<h2><s:text name="cursos.titol" /></h2>
	<div>
		<table style="border-color: #000000;border: 1px solid;" width="100%">
			<thead style="color: #FFFFFF; background-color: #000000">
     				<tr>
					
					<td><s:text name="cursos.curs" /></td>
					<td><s:text name="cursos.idiomaDelCurs" /></td>
					<td><s:text name="cursos.titolDelCurs" /></td>
					<td><s:text name="cursos.creatPer" /></td>
					
					
		 		</tr>
			</thead>

			<tbody style="color: #FFFFFF; background-color: #FF6633">
			<s:iterator value="cursosList" >
				<tr>
					
				   <s:iterator status="cursosListStatus">
				   			
				   		<s:if test="#cursosListStatus.first == true">
				   			<td style="text-align: center"><a style="text-decoration:none;color:#FF6633;" href="mostrarCurs.action?id=<s:property />"><img  src="./img/arxiu.gif"/></a></td>
				   		</s:if>
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
