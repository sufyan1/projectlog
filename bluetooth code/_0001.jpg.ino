
String Data = "";

void setup()  
{
    Serial.begin(9600);
}

void loop() // run over and over
{
    while (Serial.available())
    {
        char character = Serial.read(); // Receive a single character from the software serial port
        Data.concat(character); // Add the received character to the receive buffer
        if (character == '\n')
        {
            Serial.print("Received: ");
            Serial.println(Data);

            // Add your code to parse the received line here....

            // Clear receive buffer so we're ready to receive the next line
            Data = "";
        }
    }
}
