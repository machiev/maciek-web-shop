#!/bin/bash

echo "Please enter 'root' MySQL password"
read rootpasswd

mysql -u"root" -p${rootpasswd} -e "DROP USER IF EXISTS shopdb@localhost;"
mysql -u"root" -p${rootpasswd} -e "DROP DATABASE IF EXISTS shopdb;"
