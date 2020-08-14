#!/usr/bin/env python3

import matplotlib.pyplot as plt

colours = ['orange', 'green', 'blue', 'red']

def scatter_graph(filename, rc):
	# sfile = open("../bin/s.txt", "r")
	# aux = sfile.readlines()
	# rc = float(aux[2].split()[0])

  f = open(filename, "r")
  lines = f.readlines()
  del lines[0]
  del lines[0]
  for l in lines:
    array = l.split()
    plt.scatter(float(array[1]), float(array[2]), s=100*float(array[3]), c = colours[int(array[4])])
    # if int(array[4]) == 3:
      # plt.scatter(float(array[1]), float(array[2]), s=100*rc, facecolors='none', edgecolors='r')
  plt.title('Cell Block Method')
  plt.xlabel('Position X')
  plt.ylabel('Position Y')
  plt.show()
  return

scatter_graph("../bin/output.txt", 1)