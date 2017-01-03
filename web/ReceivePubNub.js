/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function subscribe() {
    
    pubnub = new PubNub({
        publishKey : 'pub-c-f97a90e1-2aa2-4db6-aee7-6187431f9dff',
        subscribeKey : 'sub-c-57c88d10-7fe9-11e6-82db-0619f8945a4f'
    })

    pubnub.addListener({
        status: function(statusEvent) {
            if (statusEvent.category === "PNConnectedCategory") {
                localStorage.setItem("statusPub", "PubNub Connected LocalStorage");
                var temp = localStorage.getItem("statusPub");
                
                
            }
        },
        message: function(message) {
            alert("New Message!!", message);
            console.log("**** New Message Received :", message, " ****")
            
            var json = json.parse(message);
            var sensorId = json.sensorId;
            var valueId = json.value;
            
            commandCheck(valueId, sensorId);
            
        },
        presence: function(presenceEvent) {
            // handle presence
        }
    })      
    console.log("Subscribing..");
    pubnub.subscribe({
        channels: ['hkr_channel_unit'] 
    });
};

function commandCheck(commandId, sensorId) {
    var commandId = commandId;
    log.console("PubNub Command: ", commandId );
    
    var sensorId = sensorId;
    log.console("PubNub SensorId: ", sensorId );
    
    var commandLength = commandId.length;
    log.console("CommandLength: ", commandLength );
    
    var value = commandId.substring(5, commandLength);
    commandId = commandId.substring(0,5);
    log.console("CommandId: ", commandId);
    log.console("Value: ", value);

    if (commandId.equals("11000")) {
            //readAtticTemp   response = temp
            if (value.equals("X")) {
                // error
            } else {
                //value will hold the temperature
            }
        } else if (commandId.equals("11100")) {
            //setAtticTemp      response = ack
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("12000")) {
            // readRoomTemp     response = temp
            if (value.equals("X")) {
                // error
            } else {
                //Send value to Home.jsp
                //
                //value will hold the temperature
            }
        } else if (commandId.equals("12200")) {
            //setRoomTemp       response = ack
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("13000")) {
            //readOutTemp       response = temp
            if (value.equals("X")) {
                // error
            } else {
                //value will hold the temperature
            }
        } else if (commandId.equals("14000")) {
            //readPowerCunsumption      response = power
            if (value.equals("X")) {
                // error
            } else {
                //value will hold the power
            }
        } else if (commandId.equals("15000")) {
            //readFireAlarmStatus       response = 0 or 1 (1=fire)
            if (value.equals("0")) {
                //Handle Fire Off
                localStorage.setItem("fireAlarm", "offFire");
                console.log("offFire")

            } else if (value.equals("1")) {
                //Handle Fire ON
                localStorage.setItem("fireAlarm", "onFire");
                console.log("offFire")
                

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("16000")) {
            //readBurglarAlarmStatus    response = 0 or 1 (1 = burglar)
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("17000")) {
            //read water leakage status     response = 0 or 1 (1 = leakage)
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("18000")) {
            //read stove status     response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("19000")) {
            //read window status    response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("21000")) {
            //read power outage status      response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("22000")) {
            //read attic fan status         response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("25000")) {
            //read indoor light status      response = status
            if (value.equals("0")) {
                alert("light is off");
                

            } else if (value.equals("1")) {
                alert("light is on");

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("26000")) {
            //set indoor light      response = ack
            if (value.equals("0")) {
                localStorage.setItem("light", "offLight");
                console.log("Lights is off")

                //Saving the current state to the shared prefs
                
            } else if (value.equals("1")) {
                localStorage.setItem("light", "onLight");
                console.log("Lights is on")

                //Saving the current state to the shared prefs
                
            } else if (value.equals("X")) {
                //X = error
            }

        } else if (commandId.equals("27000")) {
            //read outdoor light        response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("34000")) {
            //read outdoor light        response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("35000")) {
            //read outdoor light        response = status
            if (value.equals("0")) {
                //Handle fire ON
            } else if (value.equals("1")) {
                //Handle fire ON
            } else if (value.equals("X")) {
                //X = error
            }
        } else if (commandId.equals("36000")) {
            //read outdoor light        response = status
            if (value.equals("0")) {

            } else if (value.equals("1")) {

            } else if (value.equals("X")) {
                //X = error
            }
        }
    
    
}