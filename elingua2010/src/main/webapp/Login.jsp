<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ca" xml:lang="ca">



<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />

</head>
<body>
<s:div>
<s:form action="login" method="post">
    
    
    <s:div cssClass="login">
                    <s:div cssClass="centrat">
                        <img alt="elingua" src="./img/logo1.gif" />
                    </s:div>
                     <s:url id="localeCA" namespace="/" action="mostrarLogin.action" >
   							<s:param name="request_locale" >ca</s:param>
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarLogin.action" >
   							<s:param name="request_locale" >es</s:param>
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarLogin.action" >
   							<s:param name="request_locale" >en</s:param>
						</s:url>
						
						<s:div cssStyle="text-align: center;background-color:#000000;">
							
							<s:a href="%{localeCA}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Català |</s:a>
							<s:a href="%{localeES}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Castellano |</s:a>
							<s:a href="%{localeEN}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >English </s:a>
						</s:div>
						<s:div>
                        <fieldset>
                            <legend><b>Login:</b></legend>
                            <s:div cssClass="centrat" cssStyle="margin-left:2.4em;">
                                <s:text name="login.usuari" /><s:textfield theme="simple"  name="nomUsuari" />
                            </s:div>
                            <s:div cssClass="centrat">
                                <s:text name="login.contrasenya" /><s:password theme="simple" name="contrasenya" /> 
                            </s:div>
                            <s:fielderror />
                            <s:div cssClass="centrat">
                                <s:submit theme="simple" cssClass="btn" key="login.entrar"/>
                            </s:div>
                        </fieldset>
                        <fieldset>
                            <legend><b><s:text name="login.enregistrarse" /></b></legend>
                            <s:div cssClass="centrat">
                                <a href="<s:url action="mostrarEnregistrar"/>" class="lin"> <s:text name="login.enregistratAra" /> </a>
                            </s:div>
                        </fieldset>
                       </s:div>
                        
                        
    </s:div>

</s:form>
</s:div>
</body>
</html>