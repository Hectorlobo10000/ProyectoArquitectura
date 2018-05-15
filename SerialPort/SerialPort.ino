const int relayOne = 2;
const int relayTwo = 3;
const int relayThree = 4;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  Serial.setTimeout(2000);
  pinMode(relayOne, OUTPUT);
  pinMode(relayTwo, OUTPUT);
  pinMode(relayThree, OUTPUT);
  digitalWrite(relayOne, HIGH);
  digitalWrite(relayTwo, HIGH);
  digitalWrite(relayThree, HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available() > 0) {
    int option = Serial.parseInt();
    if(option == 1) {
     digitalWrite(relayOne, LOW);
     Serial.print("encendido \n");  
    } else if(option == -1) {
      digitalWrite(relayOne, HIGH);
      Serial.print("apagado \n"); 
    } else if(option == 2) {
      digitalWrite(relayTwo, LOW);
      Serial.print("encendido \n");
    } else if(option == -2) {
      digitalWrite(relayTwo, HIGH);
      Serial.print("apagado \n");
    } else if(option == 3) {
      digitalWrite(relayThree, LOW);
      Serial.print("encendido \n");
    } else if(option == -3) {
      digitalWrite(relayThree, HIGH);
      Serial.print("apagado \n");
    }
  }
}
