double data[256];
long start=0;

unsigned long time(){
   while (analogRead(A6) < 980) {
    delay(3);
   }
   unsigned long current = millis();
   while (analogRead(A6) > 980) {
    delay(3);
   }
   return current;
   
}

void setup() {
  // put your setup code here, to run once:
  Serial.begin(10600);
  
  
  
}

void loop() {
  // put your main code here, to run repeatedly:
  long current=0;
  start=time();
  for (int i=0;i<256;++i){
    current=time();
    if (60000/(current-start) < 200 && 60000/(current-start) > 20) {
      data[i]=60000/(current-start);
        start=current;
    }
    else i--;
    Serial.println(data[i]);
    //Serial.println(data[i]);
  }
  //for (short i=0;i<256;i++) 
  //{Serial.print(data[i]);
 //  Serial.print(" ");
  //}
  //Serial.println("");
  //Serial.println(data);
}
