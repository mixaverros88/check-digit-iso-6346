# Check Digit

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
An equivalent numerical value is assigned to each letter of the alphabet, beginning with 10 for the letter A (11 and multiples thereof are omitted):

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
Each of the numbers calculated in step 1 is multiplied by 2position, where position is the exponent to base 2. Position starts at 0, from left to right.

### Step 3
Sum up all results of Step above

### Step 4
Round the result down towards zero i.e. make the result a whole number (integer)

### Step 5
Divide them by 11

### Step 6
Multiply the integer value by 11

### Step 7
Subtract result of Step 3 from result of (6): This is the check digit.