function missatgeEnviatAlert(){
	if(document.getElementById("assumpte").value!="" &&  document.getElementById("missatge").value!=""){
		window.alert("Missatge enviat!");
	}
	
}

function carregaIdiomes(){

	var llista = document.getElementById("llista");
	var sele = document.getElementById("selectX");
	
	for (j = sele.length - 1; j>=0; j--) {
            for (i = llista.length - 1; i>0; i--) {
            	if(sele.options[j].value == llista.options[i].value){
            		sele.remove(j);
            	}
            }
		
		
    }
	
	var llista2 = document.getElementById("llista2");
	var sele2 = document.getElementById("selectX2");
	
	for (j = sele2.length - 1; j>=0; j--) {
            for (i = llista2.length - 1; i>0; i--) {
            	if(sele2.options[j].value == llista2.options[i].value){
            		sele2.remove(j);
            	}
            }
		
		
    }
	
	
	
	
}



//funcio que afegeix una llengua seleccionada  a la llista de llengues parlades
function agregar(){
//agafo el node on es mostraran les llengues escollides(menu de la dreta)
    var llista = document.getElementById("llista");
//agafo el node que llegire per saber la llengua seleccionada 
    var sele = document.getElementById("selectX");
    var i;
//aquesta es la variable que em guarda temporalment el numero d'index de la llengua seleccionada
    var seleccionat = 0;
//recorrem tota la llista fins a trobar quina  ha sigut seleccionada
    for (i = sele.length - 1; i>=0; i--) {
        if (sele.options[i].selected) {
            seleccionat = i;
            
        }
    }
var elOptNew = document.createElement('option');
//li dono els atributs pertinents i el format
            elOptNew.text = sele.options[seleccionat].text;
            elOptNew.value = sele.options[seleccionat].value;
//identifico el navegador per saber l'ordre a executar
    if(navigator.appName == "Microsoft Internet Explorer"){
//afageixo el node a la llista de la dreta
        llista.add(elOptNew);
    }
    else{
//idem per firefox
        llista.add(elOptNew, null);
    }
//esborro l'idioma seleccionat de la llista per a que no pugui tornar a ser seleccionat
    sele.remove(seleccionat);
    
}
//aquesta funcio esborra de la llista llengues ja seleccionades a la llista de la dreta
function borrar(){
    var llista = document.getElementById("llista");
    var i;
    for (i = llista.length - 1; i>0; i--) {
        if (llista.options[i].selected) {

//creo un nou node de tipus opcio i li dono els atributs pertinents
            var elOptNew = document.createElement('option');
            elOptNew.text = llista.options[i].text;
            elOptNew.value = llista.options[i].text;
//agafo el node de la llista de l'esquerra
            var sele = document.getElementById("selectX");
//segons el navegador afegeixo el node d'una manera diferent
            if(navigator.appName == "Microsoft Internet Explorer"){
                sele.add(elOptNew);
            }
            else{
                sele.add(elOptNew, null);
            }
//ara si, finalment, l'esborro de la llista de la dreta
            llista.remove(i);
            
        }
    }
}
//funcio que reinicia el formulari. Esborra tots els elements de la llista de la dreta i els fa novament seleccionables a la llista de l'esquerra 
function reiniciar(){
    var llista = document.getElementById("llista");
    var i;
    for (i = llista.length - 1; i>0; i--) {
        
            var indice = llista.options[i].text.indexOf("(");
            var texto = llista.options[i].text.slice(0,indice);
            
            var elOptNew = document.createElement('option');
            elOptNew.text = texto;
            elOptNew.value = texto;
            
            var sele = document.getElementById("selectX");
            
            if(navigator.appName == "Microsoft Internet Explorer"){
                sele.add(elOptNew);
            }
            else{
                sele.add(elOptNew, null);
            }
            llista.remove(i);
    }
    //reiniciem l'altra llista
    var llista2 = document.getElementById("llista2");
    var j;
    for (j = llista2.length - 1; j>0; j--) {
        
            var elOptNew2 = document.createElement('option');
            elOptNew2.text = llista2.options[j].text;
            elOptNew2.value = llista2.options[j].text;
            
            var sele2 = document.getElementById("selectX2");
            
            if(navigator.appName == "Microsoft Internet Explorer"){
                sele2.add(elOptNew2);
            }
            else{
                sele2.add(elOptNew2, null);
            }
            llista2.remove(j);
    }
    //reiniciem els error que han sortit en pantalla
    var misatge = window.document.getElementById("error");
    if(misatge.hasChildNodes()){
    	//eliminamos los dos ultimos (es decir, todos)
    	misatge.removeChild(misatge.lastChild);
    	misatge.removeChild(misatge.lastChild);
    }
   
}
//funcio que afegeix una llengua seleccionada  a la llista de llengues que volem apendre
function agregar2(){
//agafo el node on es mostraran les llengues escollides(menu de la dreta)
    var llista2 = document.getElementById("llista2");
//agafo el node que llegire per saber la llengua seleccionada 
    var sele = document.getElementById("selectX2");
    var i;
//aquesta es la variable que em guarda temporalment el numero d'index de la llengua seleccionada
    var seleccionat = 0;
//recorrem tota la llista fins a trobar quina  ha sigut seleccionada
    for (i = sele.length - 1; i>=0; i--) {
        if (sele.options[i].selected) {
            seleccionat = i;
            
        }
    }
//agafem el node per saber quin es el nivell seleccionat
    
    
            var elOptNew = document.createElement('option');
//li dono els atributs pertinents i el format
            elOptNew.text = sele.options[seleccionat].text;
            elOptNew.value = sele.options[seleccionat].value;
            
        
    
//identifico el navegador per saber l'ordre a executar
    if(navigator.appName == "Microsoft Internet Explorer"){
//afageixo el node a la llista de la dreta
        llista2.add(elOptNew);
    }
    else{
//idem per firefox
        llista2.add(elOptNew, null);
    }
//esborro l'idioma seleccionat de la llista per a que no pugui tornar a ser seleccionat
    sele.remove(seleccionat);
    
}
//aquesta funcio esborra de la llista llengues ja seleccionades a la llista de la dreta
function borrar2(){
    var llista2 = document.getElementById("llista2");
    var i;
    for (i = llista2.length - 1; i>0; i--) {
        if (llista2.options[i].selected) {

//creo un nou node de tipus opcio i li dono els atributs pertinents
            var elOptNew = document.createElement('option');
            elOptNew.text = llista2.options[i].text;
            elOptNew.value = llista2.options[i].text;
//agafo el node de la llista de l'esquerra
            var sele = document.getElementById("selectX2");
//segons el navegador afegeixo el node d'una manera diferent
            if(navigator.appName == "Microsoft Internet Explorer"){
                sele.add(elOptNew);
            }
            else{
                sele.add(elOptNew, null);
            }
//ara si, finalment, l'esborro de la llista de la dreta
            llista2.remove(i);
            
        }
    }
}



//funcio que activa la part del formulari seleccionada per defecte
function tipusCercaDef(){
	document.getElementById("marcatDef").checked=true;
	
	document.getElementById("nom").disabled=false;

	document.getElementById("llista2").disabled=true;
	document.getElementById("llista").disabled=true;
	document.getElementById("selectX2").disabled=true;
	document.getElementById("flechaAgregar2").disabled=true;
	document.getElementById("flechaBorrar2").disabled=true;

	
	document.getElementById("selectX").disabled=true;
	document.getElementById("flechaAgregar").disabled=true;
	document.getElementById("flechaBorrar").disabled=true;
	document.getElementById("nivell").disabled=true;
}
//funció de la cerca d'usuaris que desactiva camps del formulari segons el tipus de cerca
function tipusCerca(){
	document.getElementById("nom").disabled=true;

	document.getElementById("llista2").disabled=false;
	document.getElementById("llista").disabled=true;
	document.getElementById("selectX2").disabled=false;
	document.getElementById("flechaAgregar2").disabled=false;
	document.getElementById("flechaBorrar2").disabled=false;

	
	document.getElementById("selectX").disabled=true;
	document.getElementById("flechaAgregar").disabled=true;
	document.getElementById("flechaBorrar").disabled=true;
	document.getElementById("nivell").disabled=true;
	

}
function tipusCerca2(){
	document.getElementById("nom").disabled=true;

	document.getElementById("llista2").disabled=true;
	document.getElementById("llista").disabled=false;
	document.getElementById("selectX2").disabled=true;
	document.getElementById("flechaAgregar2").disabled=true;
	document.getElementById("flechaBorrar2").disabled=true;

	
	document.getElementById("selectX").disabled=false;
	document.getElementById("flechaAgregar").disabled=false;
	document.getElementById("flechaBorrar").disabled=false;
	document.getElementById("nivell").disabled=false;
	

}

//funcions per a l'editor de text
function diseny(){
	var editor = document.getElementById("editor");
	if (editor.addEventListener){
		editor.addEventListener("load",function(e){this.contentWindow.document.designMode = "on";}, false);
	} 
	else if (editor.attachEvent){
		editor.attachEvent("load", function(e){this.contentWindow.document.designMode = "on";});
	}

	document.getElementById("formulari").appendChild(editor);
	var br = document.createElement("br");
	document.getElementById("formulari").appendChild(br);
	var buto = document.createElement("input");
	buto.setAttribute("type", "submit");
	buto.setAttribute("value", "Guardar curs");
	buto.setAttribute("class", "btn");
	document.getElementById("formulari").appendChild(buto);

	
}

function fontEdit(x,y){
	editor.document.execCommand(x,"",y);
	editor.focus();
}



function doImage(){
    var imgSrc = prompt('Enter image location', '');
    
    if(imgSrc != null)    
     editor.document.execCommand('insertimage', false, imgSrc);
}


//boton encima
function selOn(ctrl){
	ctrl.style.borderColor = '#000000';
	
	ctrl.style.backgroundColor = '#FFBEA8';
	ctrl.style.cursor = 'hand';	
}
//boton fuera
function selOff(ctrl){
	ctrl.style.borderColor = '#D6D3CE';  
	ctrl.style.backgroundColor = '#FFFFFF';
}
//boton pulsado
function selDown(ctrl){
	ctrl.style.backgroundColor = '#FF6633';
}
//boton despulsado
function selUp(ctrl){
    ctrl.style.backgroundColor = '#FFBEA8';
}

function setHidden(){
	document.getElementById('cnt').value = editor.document.body.innerHTML;
}

//selecciona automaticament totes les opcions del select de la dreta per a que es pasin totes 
//les dades del select per parametre

function seleccionar(){
	
	var llista = document.getElementById("llista");
    var i;
    llista.options[0].selected = false;
    for (i = llista.length - 1; i>0; i--) {
            llista.options[i].selected = true;
    }
    var llista2 = document.getElementById("llista2");
    llista2.options[0].selected = false;
    var j;
    for (j = llista2.length - 1; j>0; j--) {
            llista2.options[j].selected = true;
    }
	
	
}





