#include <Servo.h>

Servo myservo;  // create servo object to control a servo
int pos = 0;
char state;
void setup()
{
  pinMode(7,OUTPUT);
  pinMode(6,OUTPUT);
  pinMode(2,OUTPUT);
  myservo.attach(4);
  pinMode(13,OUTPUT);
  Serial.begin(9600);
}

void loop(){
  if(Serial.available()){
   state=Serial.read(); 
  if(state=='1')digitalWrite(7, HIGH);
  else if(state=='a')digitalWrite(7, LOW);
  else if(state=='2')digitalWrite(6, HIGH);
  else if(state=='b')digitalWrite(6, LOW);
    else if(state=='3')digitalWrite(12, HIGH);
  
  else if(state=='d')digitalWrite(12, LOW);
  
  else if(state=='v'){
  for (pos = 0; pos <= 180; pos += 1) { 
    myservo.write(pos);              
    delay(15);                      
  }}
  else if(state=='o'){
    for (pos = 180; pos >= 0; pos -= 1) { // goes from 180 degrees to 0 degrees
    myservo.write(pos);// tell servo to go to position in variable 'pos'
    delay(15); // waits 15ms for the servo to reach the position
  }}
   else if(state=='c')digitalWrite(13, HIGH);
  
  else if(state=='e')digitalWrite(13, LOW);
  }
}
