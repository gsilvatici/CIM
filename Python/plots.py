#!/usr/bin/env python3

import matplotlib.pyplot as plt

colours = ['blue', 'orange', 'green']

def outside_limit(L, x, y, rad):
  if(x < rad or y < rad or x+rad > L or y+rad > L):
    return True
  return False

def plot_outside_limit(L, x, y, rad, colour):
  new_x = x
  new_y = y
  if(x < rad):
    new_x = x + L
  if(x + rad > L):
    new_x = x - L
  if(y < rad):
    new_y = y + L
  if(y + rad > L): 
    new_y = y - L
  axes.add_artist(plt.Circle((new_x, new_y), rad, c=colour))


def scatter_graph(filename):
  f = open(filename, "r")
  lines = f.readlines()
  del lines[0]
  del lines[0]
  plt.title('Cell Block Method')
  plt.xlabel('Position X')
  plt.ylabel('Position Y')
  plt.axis('equal')
  plt.grid(linestyle='--')
  fig = plt.gcf()
  axes = fig.gca()
  axes.set_aspect(1)
  axes.add_artist(circle)
  axes.set_xlim(0, L)
  axes.set_ylim(0, L)
  for l in lines:
    array = l.split()
    axes.add_artist(plt.Circle((float(array[1]), float(array[2])), float(array[3]), color=colours[int(array[4]) - 1]))
    if int(array[4]) == 3:
      rc_x = float(array[1])
      rc_y = float(array[2])
      circle = plt.Circle((rc_x, rc_y), rc, color='r', fill=False)
    if periodic == 1:
      if outside_limit(L, float(array[1]), float(array[2]), float(array[3])):
        plot_outside_limit(L, float(array[1]), float(array[2]), float(array[3]), colours[int(array[4]) - 1], axes)
  if periodic == 1:
    if outside_limit(L, rc_x, rc_y, rc):
      plot_outside_limit(L, rc_x, rc_y, rc, 'r', axes)
  plt.show()
  return

scatter_graph("output.txt")