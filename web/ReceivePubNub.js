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
        message: function(message) {
            console.log("New Message!!" + message.message.sensorId); 
            console.log("**** New Message Received :", message, " ****")

            var sensorId = message.message.sensorId;
            var valueId = message.message.value;
            
            commandCheck(valueId, sensorId);
            
        }
    })      
    console.log("Subscribing..");
    pubnub.subscribe({
        channels: ['hkr_channel_unit'] 
    });
};

function commandCheck(commandId, sensorId) {
    var commandId = commandId;
    console.log("PubNub Command: ", commandId );
    
    var sensorId = sensorId;
    console.log("PubNub SensorId: ", sensorId );
    
    var commandLength = commandId.length;
    console.log("CommandLength: ", commandLength );
    
    var value = commandId.substring(5, commandLength);
    commandId = commandId.substring(0,5);
    console.log("CommandId: ", commandId);
    console.log("Value: ", value);

    if (commandId == "11000") {
            //readAtticTemp   response = temp
            if (value.equals("X")) {
                // error
            } else {
                //value will hold the temperature
                localStorage.setItem("atticTemp", value);
            }
        } else if (commandId == "11100") {
            //setAtticTemp      response = ack
            if (value == "0") {
                localStorage.setItem("atticTemp", value);

            } else if (value == "1") {
                localStorage.setItem("atticTemp", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "12000") {
            // readRoomTemp     response = temp
            if (value == "X") {
                // error
            } else {
                //value will hold the temperature
                localStorage.setItem("roomTemp", value);
            }
        } else if (commandId == "12200") {
            //setRoomTemp       response = ack
            if (value == "0") {
                localStorage.setItem("roomTemp", value);

            } else if (value == "1") {
                localStorage.setItem("roomTemp", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "13000") {
            //readOutTemp       response = temp
            if (value == "X") {
                // error
            } else {
                localStorage.setItem("outTemp", value);
            }
        } else if (commandId == "14000") {
            //readPowerCunsumption      response = power
            if (value == "X") {
                // error
            } else {
                //value will hold the power
                localStorage.setItem("powerConsumption", value);
            }
        } else if (commandId == "16000") {
            //readBurglarAlarmStatus    response = 0 or 1 (1 = burglar)
            if (value == "0") {
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "1") {
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "17000") {
            //setBurglarAlarm     response = 0 or 1 (1 = leakage)
            if (value == "0") {
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "1") {
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "18000") {
            //read stove status     response = status
            if (value == "0") {
                localStorage.setItem("stoveStatus", value);
            } else if (value == "1") {
                localStorage.setItem("stoveStatus", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "19000") {
            //read window status    response = status
            if (value == "0") {
                localStorage.setItem("windowStatus", value);

            } else if (value == "1") {
                localStorage.setItem("windowStatus", value);
            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "22000") {
            //read attic fan status         response = status
            if (value == "0") {
                localStorage.setItem("atticFan", value);
            } else if (value == "1") {
                localStorage.setItem("atticFan", value);
            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "23000") {
            //set attic fan status         response = status
            if (value == "0") {
                localStorage.setItem("atticFan", value);
            } else if (value == "1") {
                localStorage.setItem("atticFan", value);
            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "25000") {
            //setAtticFan      response = status
            if (value == "0") {
                localStorage.setItem("indoorLight", value);
                alert("light is off");
                

            } else if (value == "1") {
                localStorage.setItem("indoorLight", value);
                alert("light is on");

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "26000") {
            //set indoor light      response = ack
            if (value == "0") {
                localStorage.setItem("indoorLight", value);
                console.log("Lights is off")

                //Saving the current state to the shared prefs
                
            } else if (value == "1") {
                localStorage.setItem("indoorLight", value);
                console.log("Lights is on")

                //Saving the current state to the shared prefs
                
            } else if (value == "X") {
                //X = error
            }

        } else if (commandId == "27000") {
            //read outdoor light        response = status
            if (value == "0") {
                localStorage.setItem("outdoorLight", value);

            } else if (value == "1") {
                localStorage.setItem("outdoorLight", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "28000") {
            //set outdoor light status         response = status
            if (value == "0") {
                localStorage.setItem("outdoorLight", value);
            } else if (value == "1") {
                localStorage.setItem("outdoorLight", value);
            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "34000") {
            //water leakage detected        response = status
            if (value == "0") {
                localStorage.setItem("waterLeakage", value);

            } else if (value == "1") {
                localStorage.setItem("waterLeakage", value);

            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "35000") {
            //fire detetected        response = status
            if (value == "0") {
                //Handle fire ON
                console.log("FIREALARMON")
                localStorage.setItem("fireAlarm", value);
            } else if (value == "1") {
                //Handle fire ON
                console.log("FIREALARMOFF")
                localStorage.setItem("fireAlarm", value);
            } else if (value == "X") {
                //X = error
            }
        } else if (commandId == "36000") {
            //burglar detected        response = status
            if (value == "0") {
                console.log("BURGLAROFF")
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "1") {
                console.log("BURGLARON")
                localStorage.setItem("burglarAlarm", value);

            } else if (value == "X") {
                //X = error
            }
        }
    
    
}