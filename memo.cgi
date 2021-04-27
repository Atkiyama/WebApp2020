#!/bin/bash
  printf "Content-Type: text/html\n"
  printf "\n"
  printf "<!DOCTYPE html>"
  printf "<html><head><meta charset="UTF-8" \n>"
  printf "<title>Memo CGI</title>"
  printf "<link rel="stylesheet" type="text/css" href="memo.css" />"
  printf "</head><body>"
  printf "<h1>Memo CGI</h1>"
  if [ "$REQUEST_METHOD" = "GET" ]; then
    echo "GET message" > /dev/stderr
  fi
  if [ "$REQUEST_METHOD" = "POST" ]; then
    b=$(cat /dev/stdin | awk -F= '{print $2}')
     echo "<div class="memo">${b}</div>" >> ./memo.txt
     echo "<div>Message posted</div>"
      echo "<hr />"
     echo "POST message (${b})" > /dev/stderr
  fi
  cat ./memo.txt
  printf "<a href="./memo.html">Back to html</a>"
  printf "</body></html>"
