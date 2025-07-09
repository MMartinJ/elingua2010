<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />
<script type="text/javascript" src="<s:url value="./js/javascript.js"/>"></script>
</head>
<body>
<s:div cssClass="superCapsalera">
    <s:div cssClass="capsalera">
            
                
                 <span class="capsalera2"><b><s:text name="general.sesioIni" /> <s:property value="#session.usuari.nomUsuari"/></b></span>
                <s:form action="logout" method="post">
                 	
                 	<s:submit theme="simple" value="Logout"/>
                 	<s:url id="localeCA" namespace="/" action="mostrarEnviarMissatge.action" >
   							<s:param name="request_locale" >ca</s:param>
   							<s:param name="destinatari" ><s:property value="destinatari"/></s:param>
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarEnviarMissatge.action" >
   							<s:param name="request_locale" >es</s:param>
   							<s:param name="destinatari" ><s:property value="destinatari"/></s:param>
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarEnviarMissatge.action" >
   							<s:param name="request_locale" >en</s:param>
   							<s:param name="destinatari" ><s:property value="destinatari"/></s:param>
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
                <h2 class="subtitol"><s:text name="enviarMissatge.titol" /></h2>
			<s:form action="enviarMissatge" method="post">
				<s:fielderror />
				<p>
					<b><s:text name="enviarMissatge.destinatari" /> </b> <s:textfield theme="simple" readonly="true" name="destinatari"  size="30" />
				</p>
				<p>
					<b><s:text name="enviarMissatge.assumpte" /> </b> <s:textfield theme="simple" id="assumpte" name="assumpte"  size="30" />
				</p>
				<p><b><s:text name="enviarMissatge.contingut" /> </b></p>
				<s:textarea theme="simple" id="missatge" name="missatge" cols="80" rows="9" > 
				 </s:textarea>
				<s:div>
		                    <fieldset>
		                        <s:submit onclick="missatgeEnviatAlert();" theme="simple" cssClass="btn" key="enviarMissatge.enviarMissatge"/>
		                    </fieldset>
		                    
		        </s:div>                
			</s:form>

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
