[![Build Status](https://travis-ci.com/mixaverros88/check-digit-iso-6346.svg?branch=master)](https://travis-ci.com/mixaverros88/check-digit-iso-6346)
# Check Digit ISO 6346

This repo in an implementation of the ISO 6346.

### What is ISO 6346 (wikipedia definition)
ISO 6346 is an international standard covering the coding, identification and marking of intermodal (shipping) containers used within containerized intermodal freight transport.The standard establishes a visual identification system for every container that includes a unique serial number (with check digit), the owner, a country code, a size, type and equipment category as well as any operational marks. The standard is managed by the International Container Bureau (BIC).

![preview image](https://raw.githubusercontent.com/mixaverros88/check-digit-iso-6346/master/icons/450px-Containernumber.jpg)



|Step| Container number                           | Total  |
|----|:------------------------------------------:|  -----:|
|    | C	S	Q	U	3	0	5	4	3	8     |        |
|1   | 13	30	28	32	3	0	5	4	3	8     |        |
|    | x	x	x	x	x	x	x	x	x	x     |        |
|2   | 1	2	4	8	16	32	64	128	256	512   |        |
|    | =	=	=	=	=	=	=	=	=	=     |        |
|    | 13	60	112	256	48	0	320	512	768	4096  |        |
|3   | Sum all results from (2)                   | 6185   |
|4   | Divide (3) by 11 (remainder discarded)     | 562    |
|5   | Multiply (4) by 11                         | 6182   |
|6   | (3) minus (5) = Check Digit:               | 3      |     

### Step 1
*An equivalent numerical value is assigned to each letter of the alphabet, beginning with 10 for the letter A (11 and multiples thereof are omitted):*

|0|1|2|3|4|5|6|7|8|9|
|----:|:---:|---:|---:|---:|---:|---:|---:|---:|---:|
|0|1|2|3|4|5|6|7|8|9|

|A|B|C|D|E|F|G|H|I|J|K|L|M|
|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
|10|12|13|14|15|16|17|18|19|20|21|23|24|

|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|
|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|---:|
|25|26|27|28|29|30|31|32|34|35|36|37|38

### Step 2
*Each of the numbers calculated in step 1 is multiplied by 2position, where position is the exponent to base 2. Position starts at 0, from left to right.*

### Step 3
*Sum up all results of Step above*

### Step 4
*Round the result down towards zero i.e. make the result a whole number (integer)*

### Step 5
*Divide them by 11*

### Step 6
*Multiply the integer value by 11*

### Step 7
*Subtract result of Step 3 from result of (6): This is the check digit.*


### :computer: Deploy instructions ###
Use the maven plug-in (tomcat7-maven-plugin) for tomcat server in order to automatically deploy this project in your local server. You can find this plug-in in pom.xml file in order to modify with yours configurations, also don't forget to add in settings.xml your credentials for tomcat server.
```
<servers>
    <server>
        <id>TomcatServer</id>
        <username>admin</username>
        <password>password</password>
    </server>
</servers>
```
You can run the below command in order to deploy the artifact in your local tomcat server
```
mvn clean tomcat7:deploy
```

After the deployment navigate to the following link
```
http://localhost:8080/check-digit-iso-6346/webapi/rest
```
