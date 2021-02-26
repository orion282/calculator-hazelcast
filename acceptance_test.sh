#!/bin/bash
test "$(curl -v 172.18.0.1:8765/sum?a=5\&b=6)" -eq 11
