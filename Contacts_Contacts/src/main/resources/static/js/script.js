console.log("Script loaded");
 
let ctheme = getTheme();
// REMOVE: changetheme(); 
 
document.addEventListener("DOMContentLoaded", () => { // FIXED: Corrected event name
	setupThemeToggle(); // Renamed for clarity
});
 
function setupThemeToggle() { // Renamed from changetheme
	
	changePageTheme(ctheme , ""); // Apply initial theme
	
	const changethemebutton = document.querySelector("#theme_change_button"); // ID is correct
	
    if (!changethemebutton) {
        console.error("Theme toggle button not found. Cannot attach listener.");
        return;
    }

	changethemebutton.addEventListener("click" , (event) => {
		let oldtheme = ctheme;
		console.log("change theme button clicked");
		
		if(ctheme == "dark"){
			ctheme = "light";
		}
		else{
			ctheme = "dark";
		}
		
		console.log(ctheme);
		changePageTheme(ctheme , oldtheme);
        
        // Add icon toggle logic here:
        const icon = changethemebutton.querySelector('i');
        icon.classList.toggle('fa-moon'); 
        icon.classList.toggle('fa-sun');
	});
}
 
function setTheme(theme){
	localStorage.setItem("theme" , theme);
}
 
function getTheme(){
	let theme = localStorage.getItem("theme");
	return theme ? theme : "light";
}
 
function changePageTheme(theme , oldtheme){
	setTheme(ctheme);
	
	if(oldtheme && oldtheme !== theme){
		document.querySelector("html").classList.remove(oldtheme);
	}
	
	document.querySelector("html").classList.add(theme);
	
    // REMOVED: Code that failed due to non-existent <span>
 }