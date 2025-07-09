<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />
<script type="text/javascript" src="<s:url value="/js/javascript.js"/>"></script>

</head>
<body onload="carregaIdiomes()">
<s:div cssClass="superCapsalera">
    <s:div cssClass="capsalera">
            
                <span class="capsalera2"><b><s:text name="general.sesioIni" /><s:property value="#session.usuari.nomUsuari"/></b></span>
                <s:form action="logout" method="post">
                 	<s:submit theme="simple" value="Logout"/>
                 	<s:url id="localeCA" namespace="/" action="mostrarPerfilPrivat.action" >
   							<s:param name="request_locale" >ca</s:param>
   							<s:param name="nomUsuari" ><s:property value="usuaris.nomUsuari"/></s:param>
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarPerfilPrivat.action" >
   							<s:param name="request_locale" >es</s:param>
   							<s:param name="nomUsuari" ><s:property value="usuaris.nomUsuari"/></s:param>
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarPerfilPrivat.action" >
   							<s:param name="request_locale" >en</s:param>
   							<s:param name="nomUsuari" ><s:property value="usuaris.nomUsuari"/></s:param>
						</s:url>
						
						
							
							<s:a href="%{localeCA}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Català |</s:a>
							<s:a href="%{localeES}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >Castellano |</s:a>
							<s:a href="%{localeEN}" cssStyle="color:#FFFFFF;text-decoration:none;font: bold 84% 'trebuchet ms',helvetica,sans-serif;" >English </s:a>
						
                 	
                </s:form>
                
    </s:div>
    
    
    <s:div cssClass="capsalera3"><h1><s:text name="general.titolGeneral" /></h1><img alt="elingua" src="./img/logo1.gif"  /></s:div>
    
    <iframe frameborder="0" style="margin-top:12%;position:absolute;z-index:3" src ="menu.html" width="100%" height="40px">
        <p><s:text name="general.avisIframe" /></p>
    </iframe>
    
</s:div>
    <s:div cssClass="contingut" cssStyle="margin-top:15%">
        
        <h1 class="titol"><s:text name="perfilPrivat.titol" /></h1>
        
                <fieldset>
                <h2 class="subtitol"><s:text name="perfilPrivat.subtitol" /></h2>
                	
                    <s:form action="modificarPerfil" method="post" >
                        <s:div>
                        	<s:fielderror />
                        	
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.nomCog" /></b></legend>
                                
                                <s:text name="perfilPrivat.nom" /> <s:textfield theme="simple" maxlength="15"  name="basics.nom" /><br/>
                                <s:text name="perfilPrivat.cog1" /> <s:textfield theme="simple" maxlength="15" name="basics.cognom1" />
                                <s:text name="perfilPrivat.cog2" /> <s:textfield theme="simple" maxlength="15" name="basics.cognom2" />
                            
                            </fieldset>
                        </s:div>
                        
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.dataNaix" /></b></legend>
                                
                                <s:text name="format.date"><s:textfield theme="simple" name="basics.dataNaix" size="6" maxlength="8"/></s:text>
                                
                                
                            </fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.sexeLeg" /></b></legend>
                                	
   									<s:radio theme="simple" name="basics.sexe" list="sexesList" />
										
										
                                			
                                       
                            </fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.adrecaElecLeg" /></b></legend>
                                    <s:text name="perfilPrivat.adrecaElec" /> <s:textfield theme="simple" maxlength="30" name="basics.email" id="email"/>
                            </fieldset>
                        </s:div>
                        <h2 class="subtitol"><s:text name="perfilPrivat.dadesPerfSubtitol" /></h2>
                        <s:div>
                            
                                
                                    <fieldset>
                                    <legend><b><s:text name="perfilPrivat.dadesUsuLeg" /></b></legend>
                                        <s:text name="perfilPrivat.nomUsu" />  <s:textfield theme="simple" readonly="true"  name="usuaris.nomUsuari" />
                                        
                                    </fieldset>
                        </s:div>
                        <s:div>
                                    <fieldset>
                                    <legend><b><s:text name="perfilPrivat.contrasenyaLeg" /></b></legend>
                                        <s:text name="perfilPrivat.contrasenya1" /> <s:password showPassword="true" theme="simple" maxlength="15" name="usuaris.psswd" id="pass" /> 
                                        <s:text name="perfilPrivat.contrasenya2" /> <s:password showPassword="true" theme="simple" maxlength="15" name="contrasenya2" id="pass2" /> 
                                    </fieldset>
                            
                        </s:div>
                        <s:div>
                        	<fieldset>
                                <legend><b><s:text name="perfilPrivat.llenguesPropiesLeg" /></b></legend>
                                	
                                	
                        			<s:div cssClass="colizq">
                        				<label for="parlada"><s:text name="perfilPrivat.selVostraLlengua" /></label>
                        				<s:select theme="simple" id="selectX" headerKey="-1" list="idiomesLlista" />
                        				
                        			
                                    	<input style="position: absolute;left:50%;z-index:0" onclick="agregar();" type="button" value="&gt;&gt;" class="btn"/><br/>
                                    	<input style="position: absolute;left:50%;z-index:0" onclick="borrar();" type="button" value="&lt;&lt;" class="btn"/>
                                	</s:div>
                                	<s:div cssClass="colder">
                                		<s:select theme="simple" id="llista" headerKey="-1"  list="llistaIdiSap" name="idiomesSele" size="5" multiple="true" cssClass="opt"/>
                                	
	                                    
	                                        
                                	</s:div>
                        			
                        			
                        			
                        			
                        	</fieldset>
                        </s:div>
                        <s:div>
                        	<fieldset>
                                <legend><b><s:text name="perfilPrivat.llenguesAprendreLeg" /></b></legend>
                                	
                                	
                        			<s:div cssClass="colizq">
                        				<label for="parlada"><s:text name="perfilPrivat.selLlenguaAprendre" /></label>
                        				<s:select theme="simple" id="selectX2" headerKey="-1" list="idiomesLlista" />
                        				
                        			
                                    	<input style="position: absolute;left:50%;z-index:0" onclick="agregar2();" type="button" value="&gt;&gt;" class="btn"/><br/>
                                    	<input style="position: absolute;left:50%;z-index:0" onclick="borrar2();" type="button" value="&lt;&lt;" class="btn"/>
                                	</s:div>
                                	<s:div cssClass="colder">
                                		<s:select theme="simple" id="llista2" headerKey="-1"  list="llistaIdiEst" name="idiomesSeleApren" size="5" multiple="true" cssClass="opt"/>
                                	
	                                    
	                                        
                                	</s:div>
                        			
                        			
                        			
                        			
                        	</fieldset>
                        </s:div>
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="perfilPrivat.privadesaLeg" /></b></legend>
                                       <s:text name="perfilPrivat.privadesa" /><s:checkbox theme="simple" name="usuaris.privacitat"  />
                            </fieldset>
                            
                        </s:div>
                        
                        <s:if test="#session.usuari.nomUsuari == 'admin'">
                        <s:hidden name="admin" value="admin" />
                        <s:div>
                        <fieldset>
                                <legend><b><s:text name="perfilPrivat.tipusUsuLeg" /></b></legend>
                        	
                        	<s:radio theme="simple" name="usuaris.tipus" list="tipusUsu" />
                        </fieldset>
                        </s:div>
                        </s:if>
                        <s:else>
                        	<s:hidden name="admin" value="no" />
                        	<s:if test="#session.usuari.tipus == 'basic'">
                        		<s:hidden name="usuaris.tipus" value="basic" />
                        	</s:if>
                        	<s:else>
                        		<s:hidden name="usuaris.tipus" value="collaborador" />
                        	</s:else>
                        </s:else>
                        
                        <s:submit theme="simple" onclick="seleccionar();" cssClass="btn" key="perfilPrivat.modificarPerfilBoto"/>
                        
                         <s:reset theme="simple"  key="perfilPrivat.EsborrarDadesBoto" cssClass="btn"/>
                        
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
