<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />
<script type="text/javascript" src="<s:url value="/js/javascript.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/validador.js"/>"></script>
</head>
<body onload="tipusCercaDef()">
<s:div cssClass="superCapsalera">
    <s:div cssClass="capsalera">
            
                
                <span class="capsalera2"><b><s:text name="general.sesioIni" /> <s:property value="#session.usuari.nomUsuari"/></b></span>
                <s:form action="logout" method="post">
                 	<s:submit theme="simple" value="Logout"/>
                 	<s:url id="localeCA" namespace="/" action="mostrarCercarUsuari.action" >
   							<s:param name="request_locale" >ca</s:param>
   							
						</s:url>
						<s:url id="localeES" namespace="/" action="mostrarCercarUsuari.action" >
   							<s:param name="request_locale" >es</s:param>
   							
						</s:url>
						<s:url id="localeEN" namespace="/" action="mostrarCercarUsuari.action" >
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
                               <legend><b><s:text name="cerca.llistaUsuTrobats" /></b></legend>
                               	
                                       
                                       <table border="1"  width="100%">
                                       
                                    	<s:iterator  value="usuaris" status="usuarisStatus">
                                    	<s:if test="#usuarisStatus.first == true">
                                    		<thead>
                                    			<tr style="color: #FFFFFF; background-color: #000000">
                                    				<td ><s:text name="cerca.nomUsu" /></td>
        											<td><s:text name="cerca.perfUsu" /> </td>
                                    			</tr>
                                    		</thead>
                                       </s:if>
                                       		<tr width="80,20">
        										<td style="color: #FFFFFF; background-color: #FF6633">    <s:property /></td>
        										<td style="color: #FFFFFF; background-color: #FF6633"><a  href="mostrarPerfilPublic.action?usuari=<s:property />"><s:text name="cerca.veurePerf" /> </a></td>
        									</tr>
      									</s:iterator>
									</table>
                                    	
                                    
                                <s:if test="usuaris.size()==0">   	
                                    <p style="text-align:center"><b><s:text name="cerca.noShanTrobatUsu" /></b></p>
                                </s:if> 
               </fieldset>
               <fieldset>
               			 <legend><b><s:text name="cerca.enviarMissatgeAdminLeg" /></b></legend>
               				<a href="mostrarEnviarMissatge.action?destinatari=admin" class="lin"  ><s:text name="cerca.enviarMissatgeAdmin" /></a>
               </fieldset>
        <fieldset>
                <h2 class="subtitol"><s:text name="cerca.introDadesCercUsu" /></h2>
                    <s:form action="cercarUsuari" method="post">
			<s:div>
                            <fieldset>
                                <legend><b><s:text name="cerca.tipusDeCerca" /></b></legend>
                                        <input onclick="tipusCercaDef()" id="marcatDef" type="radio" name="cerca" value="usuari"/><s:text name="cerca.perNomUsu" /><br/>
                                        <input onclick="tipusCerca()" type="radio" name="cerca" value="idioma"/><s:text name="cerca.perIdiUsuApren" /><br/>
					<input onclick="tipusCerca2()" type="radio" name="cerca" value="idioma2"/><s:text name="cerca.perIdiUsuSap" />
                            </fieldset>
                        </s:div>
                        <s:div>
                        	
                            <fieldset>
                                <legend><b><s:text name="cerca.nomUsuari" /></b></legend>
                                
                                <s:text name="cerca.nomUsuari" /> <s:textfield theme="simple" disabled="disabled" maxlength="15" name="nom" id="nom"/>
                                <s:fielderror />
                            
                            
                            </fieldset>
                        </s:div>
                        
                        <s:div>
                            <fieldset>
                                <legend><b><s:text name="cerca.llenguesUsuApren" /></b></legend>
                                
                                <s:div cssClass="colizq">
                                    <label for="parlada"><s:text name="cerca.selecLallengua" /></label>
                                        <s:select theme="simple" disabled="true" id="llista2" headerKey="-1" list="idiomesLlista" name="idiomaSeleEst" />
                                        
                                </s:div>
                               
                                
                                
                            </fieldset>
                        </s:div>
			<s:div>
                            <fieldset>
                                <legend><b><s:text name="cerca.llenguesUsuConeix" /></b></legend>
                                
                                <s:div cssClass="colizq">
                                    <label for="parlada"><s:text name="cerca.selecLallengua" /></label>
                                        <s:select theme="simple" disabled="true" id="llista" headerKey="-1" list="idiomesLlista" name="idiomaSeleSap"/>
                                        
                                </s:div>
                               
                               
                                
                            </fieldset>
                            
                        </s:div>
                        
                        
                        
                        
                        
                       <s:submit theme="simple" key="cerca.cercar" cssClass="btn" />
                        
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
