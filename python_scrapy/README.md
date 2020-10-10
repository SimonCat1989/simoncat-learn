# Install Python 3 and Pip

We will use Python 3 for this tutorial.  To start, you need a computer with Python 3 and PIP .

$ python3 --version

$ sudo apt-get update
$ sudo apt-get install python3.6

$ sudo apt install python3-pip

$ pip3 install scrapy

# Create a Scrapy Project 

$ scrapy startproject python_scrapy

# Create a Spider 

$ scrapy genspider {spidername} {website}

e.g. $ scrapy genspider alibaba_crawler alibaba.com

# Command to run

$ scrapy crawl {spidername} -o output_filename.csv -t csv
$ scrapy crawl {spidername} -o output_filename.json -t json

e.g. scrapy crawl alibaba_crawler -o alibaba.csv -t csv

# Debug with specific URL

$ scrapy shell {target_URL}

In case you meet 'DEBUG: Forbidden by robots.txt', find settings.py then change ROBOTSTXT_OBEY from 'True' to 'False'