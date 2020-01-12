#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Jan 12 01:14:40 2020

@author: WeiSijia
"""

import pandas as pd

J = '/Users/weisijia/Desktop/var/murder.json' 


df = pd.read_json(J)
df = df.T
df

df.to_excel("data.xlsx")