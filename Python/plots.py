#!/usr/bin/env python3

import matplotlib.pyplot as plt

colours = ['blue', 'orange', 'green']

def outside_limit(L, x, y, rad):
  if(x < rad or y < rad or x+rad > L or y+rad > L):
    return True
  return False

def get_new_point(L, point, rad):
  new_p = point
  if(point < rad):
    new_p = point + L
  if(point + rad > L):
    new_p = point - L
  return new_p


def scatter_graph(filename):
  f = open(filename, "r")
  lines = f.readlines()
  N = int(lines.pop(0))
  L = int(lines.pop(0))
  rc = float(lines.pop(0))
  periodic = int(lines.pop(0))
  plt.title('Cell Block Method')
  plt.xlabel('Position X')
  plt.ylabel('Position Y')
  fig = plt.gcf()
  axes = fig.gca()
  for l in lines:
    array = l.split()
    axes.add_artist(plt.Circle((float(array[1]), float(array[2])), float(array[3]), color=colours[int(array[4]) - 1]))
    if int(array[4]) == 3:
      rc_x = float(array[1])
      rc_y = float(array[2])
      rc_rad = float(array[3])
    if periodic == 1:
      if outside_limit(L, float(array[1]), float(array[2]), float(array[3])):
        new_x = get_new_point(L, float(array[1]), float(array[3]))
        new_y = get_new_point(L, float(array[2]), float(array[3]))
        axes.add_artist(plt.Circle((new_x, new_y), float(array[3]), color=colours[int(array[4]) - 1]))
  if periodic == 1:
    if outside_limit(L, rc_x, rc_y, rc-rc_rad):
      axes.add_artist(plt.Circle((rc_x, rc_y), rc - rc_rad, color='r', fill=False))
      new_x = get_new_point(L, rc_x, rc-rc_rad)
      new_y = get_new_point(L, rc_y, rc-rc_rad)
      axes.add_artist(plt.Circle((new_x, new_y), rc-rc_rad, color='r', fill=False))
  else:
      axes.add_artist(plt.Circle((rc_x, rc_y), rc + rc_rad, color='r', fill=False))
  axes.set_xlim(0, L)
  axes.set_ylim(0, L)
  plt.show()
  return

scatter_graph("output.txt")
