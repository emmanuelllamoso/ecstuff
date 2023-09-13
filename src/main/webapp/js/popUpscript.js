/**
 * 
 */
let popup = document.getElementById("popup");

        function openPopup(){
            document.documentElement.style.overflow = 'hidden';  // Disable scroll on <html>
            document.body.style.overflow = 'hidden';    		 // Disable scroll on <body>
            document.getElementById('overlay').style.display = 'block'; // Show the overlay
            popup.classList.add("open-popup"); 
        }
        function closePopup(){
        	document.documentElement.style.overflow = 'auto';    // Enable scroll on <html>
            document.body.style.overflow = 'auto';               // Enable scroll on <body>
            document.getElementById('overlay').style.display = 'none'; // Hide the overlay
            popup.classList.remove("open-popup");
           
        }
        
     // Function to prevent the default scroll behavior
        function preventDefaultScroll(event) {
            event.preventDefault();
        }

        // Usage example:

        // Disable scrolling
        disableScroll();
