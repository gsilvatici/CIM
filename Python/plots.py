#!/usr/bin/env python3

import matplotlib.pyplot as plt

colours = ['orange', 'green', 'blue']

def scatter_graph(filename, particle):
  f = open(filename, "r")
  lines = f.readlines()
  del lines[0]
  del lines[0]
  for l in lines:
    array = l.split()
    plt.scatter(float(array[1]), float(array[2]), s=100*int(array[3]), c = colours[int(array[4])])
    if int(array[0]) == particle:
      plt.scatter(float(array[1]), float(array[2]), s=500, facecolors='none', edgecolors='r')
  plt.title('Cell Block Method')
  plt.xlabel('Position X')
  plt.ylabel('Position Y')
  plt.show()
  return

  def M_compare():
    f = open(filename, "r")
    lines = f.readlines()
    for l in lines:
      array = l.split()
      plt.plot(float(array[0]), float(array[1]))
    plt.title('Time comparison with M variable')
    plt.xlabel('M')
    plt.ylabel('Execution Time')
    plt.show()
  return


scatter_graph("Dynamic100", 1)