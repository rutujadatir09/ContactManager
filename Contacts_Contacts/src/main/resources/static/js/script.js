 console.log("Script loaded");
 
 let ctheme = gettheme();
 changetheme();
 
 function changetheme(){
	document.querySelector("html").classlist.add(ctheme);
 }
 
 function settheme(theme){
	localStorage.setitem("theme" , theme);
 }
 
 function gettheme(){
	let theme = localStorage.getitem("theme");
	return theme ? theme : "light";
 }