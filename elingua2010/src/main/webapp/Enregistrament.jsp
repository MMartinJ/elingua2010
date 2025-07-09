<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
            
                <s:form cssClass="capsalera2" action="login" method="post">
                    <b><s:text name="login.usuari" /></b> <s:textfield theme="simple"  name="nomUsuari" />
                    <b><s:text name="login.contrasenya" /></b> <s:password theme="simple" name="contrasenya" /> 
                    <s:submit theme="simple" cssClass="btn" key="login.entrar"/>
                </s:form>
                <s:url id="localeCA" namespace="/" action="mostrarEnregistrar.action" >
   							<s:param name="request_locale" >ca</s:param>
   							
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarEnregistrar.action" >
   							<s:param name="request_locale" >es</s:param>
   							
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarEnregistrar.action" >
   							<s:param name="request_locale" >en</s:param>
   							
						</s:url>
						
						
							
							<s:a href="%{localeCA}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Català |</s:a>
							<s:a href="%{localeES}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Castellano |</s:a>
							<s:a href="%{localeEN}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >English </s:a>
						
    </s:div>
    
    
    <s:div cssClass="capsalera3"><h1><s:text name="general.titolGeneral" /></h1><img alt="elingua" src="./img/logo1.gif"  /></s:div>
    
    
    
</s:div>
    <s:div cssClass="contingut">
        
        <h1 class="titol"><s:text name="perfilPrivat.titol" /></h1>
        
                <fieldset>
                <h2 class="subtitol"><s:text name="perfilPrivat.subtitol" /></h2>
                	
                    <s:form action="enregistrar" method="post" >
                        <s:div>
                        	<s:fielderror />
                        	
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.nomCog" /></b></legend>
                                
                                <s:text name="perfilPrivat.nom" /> <s:textfield theme="simple" maxlength="15"  name="basic.nom" /><br/>
                                <s:text name="perfilPrivat.cog1" /> <s:textfield theme="simple" maxlength="15" name="basic.cognom1" />
                                <s:text name="perfilPrivat.cog2" /> <s:textfield theme="simple" maxlength="15" name="basic.cognom2" />
                            
                            </fieldset>
                        </s:div>
                        
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.dataNaix" /></b></legend>
                                
                                <s:textfield theme="simple" name="basic.dataNaix" size="6" maxlength="8"/>
                                
                                
                            </fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.sexeLeg" /></b></legend>
                                		 <s:radio theme="simple" name="basic.sexe" list="sexesList" value="1" />
                                        
                            </fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.adrecaElecLeg" /></b></legend>
                                    <s:text name="perfilPrivat.adrecaElec" /> <s:textfield theme="simple" maxlength="30" name="basic.email" id="email"/>
                            </fieldset>
                        </s:div>
                        <h2 class="subtitol"><s:text name="perfilPrivat.dadesPerfSubtitol" /></h2>
                        <s:div>
                            
                                
                                    <fieldset>
                                    <legend><b><s:text name="perfilPrivat.dadesUsuLeg" /></b></legend>
                                        <s:text name="perfilPrivat.nomUsu" />  <s:textfield theme="simple" maxlength="15" name="usuari.nomUsuari" />
                                        
                                    </fieldset>
                        </s:div>
                        <s:div>
                                    <fieldset>
                                    <legend><b><s:text name="perfilPrivat.contrasenyaLeg" /></b></legend>
                                        <s:text name="perfilPrivat.contrasenya1" /> <s:password theme="simple" maxlength="15" name="usuari.psswd" id="pass" /> 
                                        <s:text name="perfilPrivat.contrasenya2" /> <s:password theme="simple" maxlength="15" name="contrasenya2" id="pass2" /> 
                                    </fieldset>
                            
                        </s:div>
                        <s:div>
                        	<fieldset>
                                <legend><b><s:text name="perfilPrivat.llenguesPropiesLeg" /></b></legend>
                                	
                                	
                        			
                        			<s:div cssClass="colizq">
                        				<label for="parlada"><s:text name="perfilPrivat.selVostraLlengua" /></label>
                        				<s:select theme="simple" id="selectX" headerKey="-1" list="idiomesLlista" />
                        				
                        				
                                    	<input style="position: absolute;left:50%;" onclick="agregar();" type="button" value="&gt;&gt;" class="btn"/><br/>
                                    	<input style="position: absolute;left:50%;" onclick="borrar();" type="button" value="&lt;&lt;" class="btn"/>
                                    	
                                	</s:div>
                                	<s:div cssClass="colder">
                                		<s:select theme="simple" id="llista" headerKey="-1" list="selLlista" name="idiomesSele" size="5" multiple="true" cssClass="opt"/>
                                	
                                	</s:div>
                        			
                        			
                        			
                        			
                        	</fieldset>
                        </s:div>
                        <s:div>
                        	<fieldset>
                                <legend><b><s:text name="perfilPrivat.llenguesAprendreLeg" /></b></legend>
                                	
                                	
                        			<s:div cssClass="colizq">
                        				<label for="parlada"><s:text name="perfilPrivat.selLlenguaAprendre" /></label>
                        				<s:select theme="simple" id="selectX2" headerKey="-1" list="idiomesLlista" />
                        				
                        			
                        			
                                    	<input style="position: absolute;left:50%;" onclick="agregar2();" type="button" value="&gt;&gt;" class="btn"/><br/>
                                    	<input style="position: absolute;left:50%;" onclick="borrar2();" type="button" value="&lt;&lt;" class="btn"/>
                                	</s:div>
                                	<s:div cssClass="colder">
                                		<s:select theme="simple" id="llista2" headerKey="-1" list="selLlista" name="idiomesSeleApren" size="5" multiple="true" cssClass="opt"/>
                                	
	                                    
	                                        
                                	</s:div>
                        			
                        			
                        			
                        			
                        	</fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.privadesaLeg" /></b></legend>
                                       <s:text name="perfilPrivat.privadesa" /><s:checkbox theme="simple" name="usuari.privacitat"  />
                            </fieldset>
                            
                        </s:div>
                        <s:hidden name="usuari.tipus" value="basic" />
                        
                        <s:submit theme="simple" onclick="seleccionar();" cssClass="btn" key="enregistrament.enregistrarse"/>
                        
                         <s:reset theme="simple" onclick="reiniciar();" key="perfilPrivat.EsborrarDadesBoto" cssClass="btn"/>
                        
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
