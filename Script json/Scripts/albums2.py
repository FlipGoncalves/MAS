import tweepy
import requests
import os
from datetime import date

auth = tweepy.OAuthHandler("O8bYthiRMXMEHhBwnIaY4krmc","Ojd1HjImLBtbaZipowKq7M3EwIws83Py0jWqah1RB9tDtWdVD1")
auth.set_access_token("1253152396382998530-fZehFjmEg4cZOHaZFIJ035QweLZomJ","ZqqwNjK2O6Q6AJ4dbqu95CnG3fRforDE04m6fGCzVWKKt")

api = tweepy.API(auth, wait_on_rate_limit=True, wait_on_rate_limit_notify=True)



today = date.today()

d = today.strftime("%d/%m/%Y")

api = tweepy.API(auth, wait_on_rate_limit=True,
	wait_on_rate_limit_notify=True)

day = d[:2]
month = d[3:5]
year = d[6:10]

def tweet_image(url, message):
	api = tweepy.API(auth, wait_on_rate_limit=True, wait_on_rate_limit_notify=True)
	filename = "temp.jpg"
	request = requests.get(url, stream=True)
	if request.status_code == 200:
		with open(filename, "wb") as image:
			for chunk in request:
				image.write(chunk)

		api.update_with_media(filename, status=message)
		os.remove(filename)
	else:
		print("Unable to download image")



def post_tweet():
	f = open("albums.txt","r")
	for line in f:
		if line.startswith("\n"):
			break
		vals = line.split("\t");
		vals[3] = vals[3].strip()
		if (day == vals[2][:2] and month == vals[2][3:5]):
			age = int(year) - int(vals[2][6:10])
			message = vals[1] + " by " + vals[0] + " came out on this day " + str(age) + " years ago"
			tweet_image(vals[3],message)


post_tweet()
			


