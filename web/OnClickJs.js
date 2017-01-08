/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function onClickLight(clicked_id) {
    if (clicked_id = "indoorLightButton") {
        var lightStatus = document.getElementById("result").innerHTML = localStorage.getItem("");
        console.log(lightStatus)
        if (lightStatus != null) {
            if (lightStatus = "offLight") {
                //do send status change    

                //change button name with the context of the button as parameter
                document.getElementById(clicked_id).textContent = "Light On";
            } else if (lightStatus = "onLight") {
                //do send status change    

                //change button name with the context of the button as parameter
                document.getElementById(clicked_id).textContent = "Light Off";
            }
        } else {
            //Get status and set name accordingly, set localStorage light accordingly aswell

            console.log("ERROR: LightStatus = Null")
        }
        console.log(clicked_id);
    }
    else{
        var lightStatus = document.getElementById("result").innerHTML = localStorage.getItem("");
        console.log(lightStatus)
        if (lightStatus != null) {
            if (lightStatus = "offLight") {
                //do send status change    

                //change button name with the context of the button as parameter
                document.getElementById(clicked_id).textContent = "Light On";
            } else if (lightStatus = "onLight") {
                //do send status change    

                //change button name with the context of the button as parameter
                document.getElementById(clicked_id).textContent = "Light Off";
            }
        } else {
            //Get status and set name accordingly, set localStorage light accordingly aswell

            console.log("ERROR: LightStatus = Null")
        }
        console.log(clicked_id);
    }

}

