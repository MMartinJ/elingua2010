<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">


<head>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>elingua</title>
<script type="text/javascript" src="<s:url value="./js/javascript.js"/>"></script>
<link rel="stylesheet" href="<s:url value="/css/estil.css"/>" />

<style type="text/css">
        @import "./dojo/dijit/themes/tundra/tundra.css";
       
    </style>
  
   
    <script type="text/javascript" src="./dojo/dojo/dojo.js" djConfig="isDebug: true, parseOnLoad: true,locale: '${meuLocale}'" ></script>
  
  
	
    
    
 
    <script type="text/javascript">
    	
    	dojo.require("dojo.i18n");
 		
    	
 		
        dojo.require("dojo.parser");
        dojo.require("dijit.form.ValidationTextBox");
        dojo.require("dijit.form.Form");
        dojo.require("dijit.form.Button");
        dojo.require("dijit.Editor");
        dojo.require("dijit._editor.plugins.FontChoice");
        dojo.require("dijit._editor.plugins.LinkDialog");
        
        
        
 
        dojo.addOnLoad(linkTextForSubmit);
 
        function linkTextForSubmit() {
            dojo.connect(dojo.byId('formulari'), 'onsubmit', updateEditorText);
        }
 
        function updateEditorText(evt) {
            editorContent = dijit.byId('descrEditor').getValue(false);
            if (!content) {
                alert("The description cannot be blank");
                evt.preventDefault();
            }
            dojo.byId('cnt').value = editorContent;
        }
         
    </script>

</head>
<body>
<s:div cssClass="superCapsalera">
    <s:div cssClass="capsalera">
            
                
                 <span class="capsalera2"><b><s:text name="general.sesioIni" /> <s:property value="#session.usuari.nomUsuari"/></b></span>
                <s:form action="logout" method="post">
                 	<s:submit theme="simple" value="Logout"/>
                 	
                 	
                </s:form>
    </s:div>
    
    
    <s:div cssClass="capsalera3"><h1><s:text name="general.titolGeneral" /></h1><img alt="elingua" src="./img/logo1.gif"  /></s:div>
    
    <iframe frameborder="0" style="margin-top:12%;" src ="menu.html" width="100%" height="40px">
        <p><s:text name="general.avisIframe" /></p>
    </iframe>
</s:div>
    <s:div cssClass="contingut" cssStyle="margin-top:15%">
        <fieldset>
		<h2><s:text name="nouCurs.titol" /></h2>
	
        
       <s:form id="formulari" dojoType="dijit.form.Form" method="post" commandName="bait" action="crearCurs">
       <s:fielderror />
	<s:div>
	<p>
		<s:text name="nouCurs.selecciomaIdioma" />
		<s:select theme="simple" id="selectX" name="idiomaSele" headerKey="-1" list="idiomesLlista" />
    </p>                            	
	</s:div>
	<s:div>
	<p>
		<s:text name="nouCurs.titolDelCurs" /><s:textfield name="titol" size="50" maxlength="30" theme="simple"/>
	</p>
	
	
	</s:div>
	<div dojoType="dijit.Editor" style="border:3px solid black;" id="descrEditor" extraPlugins="['insertImage','createLink','fontSize']">
	<s:property escape="false" value="cnt"/> 
                        <c:out value="${bait.cnt}" escapeXml="false"/>
                    </div>
                    <s:hidden id="cnt" name="cnt" path="cnt"/>
                    
                         
                    <s:hidden path="baitId"/>
	
	
                    
	
	<button type="submit" dojoType="dijit.form.Button" name="submitButton" style="color:#FFFFFF;font: bold 84% 'trebuchet ms',helvetica,sans-serif;background-color:#FF6633;border: 1px solid;border-color: #000000;"/><s:text name="nouCurs.desarCurs" /></button>
	
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
