#!/bin/bash
test "$(curl -v 172.17.0.5:8080/sum?a=5\&b=6)" -eq 11
