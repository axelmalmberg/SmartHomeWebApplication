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
                alert("Connected to PubNub");
            }
        },
        message: function(message) {
            alert("New Message!!", message);
            console.log("**** New Message Received :", message, " ****")
            
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