<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-compatible" content="IE-edge">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>AllNetText</title>
        <link rel="icon" type="image/jpg" href="images/icon.jpg"> 
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/popUp.css">
        <script src="https://kit.fontawesome.com/3335c097ff.js" crossorigin="anonymous"></script>
        
    </head>
    
    <body>
        <div class="overlay" id="overlay"></div>
    
        <div class="header">
            <nav>
                <img src="images/logo.png"></img>
                <ul>
                    <li><a class="smooth-scroll" href="index.jsp">Home</a></li>
                    <li><a class="smooth-scroll" href="#about">About</a></li>
                    <li><a class="smooth-scroll" href="#contact">Contact</a></li>
                </ul>
					<script>
					  document.querySelectorAll('.smooth-scroll').forEach(anchor => {
					    anchor.addEventListener('click', function(e) {
					      e.preventDefault();
					
					      const targetId = this.getAttribute('href').substring(1);
					      const targetElement = document.getElementById(targetId);
					
					      if (targetElement) {
					        window.scrollTo({
					          top: targetElement.offsetTop,
					          behavior: 'smooth' // This enables smooth scrolling
					        });
					      }
					    });
					  });
					</script>
            </nav>

            <div class="text-box" id="about">
                <h1> AllNetText: <br>Bridging Communication Gaps, One Message at a Time</h1>
                <p>
                    In a world where connectivity is essential, we're thrilled to introduce AllNetText, your go-to website for sending SMS messages to individuals who may not have any available load balance on their mobile devices. At AllNetText, we believe that communication should be accessible to everyone, regardless of their current mobile credit status.
                </p>
            </div>

        </div> 
		
		
        <div class="box1">   
        	
            <h3>Instruction: Please input your mobile number using one of the following formats: 
            <span id="intruction">"09xxxxxxxxx" or "9xxxxxxxxx". Afterward, compose your message 
            <span id="intruction">and proceed to send it.</span></span></h3>
           
            
            <form action="getSMSControl" class="smsTextBox" method="post">
                <label for="phone" id="labelPhone">Phone number:</label>
                <span style="font-size: 1.2em;">+63</span>
                <input type="text" id="phone" name="phone" input>

                <label for="message" id="labelMessage" style="display: block; margin: 5px;">Message:</label>
                <textarea id="message" name="message" rows="4" cols="50"></textarea>
                <p id="noteSms">1 SMS <span id="countRemainingcharaters">160</span> Characters left.</p>
                
                <input type="submit" id="submit" value="SEND" onclick="disable(this)">
                
                <script src="js/script.js"></script>
            </form>
        </div>
       
       <div class="container">
        <div class="popup" id="popup">
            <img src="images/tick.png">
            <h2>Thank You!</h2>
            <p>We will approach you later with regards to your concern.</p>
            <button type="button" id = "feedbackServ" onclick="closePopup()">OK</button>
        </div>
       </div>

       <script src="js/popUpscript.js"></script>
                 	
        <div class="footer" id="contact">
            <div class="col-1">
                <h3>Feedback:</h3>
                <form id="feedback" action="feedbackServlet" method="POST">
                    <input type="email" name="email" placeholder="Your Email Address" required><br>
                    <textarea id="feedback" name="concern" rows="4" cols="40" required></textarea><br>
                    <button type="button" onclick="openPopup()">Submit</button>
                </form>
            </div>
            
        <script>
            document.getElementById('feedbackServ').addEventListener('click', function() {
                // Programmatically trigger the form submission
            document.getElementById('feedback').submit();
            });
        </script>
    

            <div class="col-2">
                <h3>Contact</h3>
                <p>emmanuelllamoso@gmail.com</p>
                <p>+639676426413</p>
                

                <br><br>

                <h3>Address:</h3>
                <p>Cavinti, Laguna</p>

                <div class="social-icons">
                    <a href="https://www.facebook.com/Angelica.Abad.4/"><i class="fa-brands fa-facebook"></i></a>
                    <a href="https://www.facebook.com/Angelica.Abad.4/"><i class="fa-brands fa-google"></i></a>
                    <a href="https://www.instagram.com/emmanuelllamoso/"><i class="fa-brands fa-instagram"></i></a>
                    <a href="https://www.youtube.com/channel/UCFceDxMYUg7ujvL71nmojfw"><i class="fa-brands fa-youtube"></i></a>
                </div>
                
            </div>
        </div>
        
    </body>
</html>