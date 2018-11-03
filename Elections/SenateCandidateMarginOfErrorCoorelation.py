import numpy as np
import matplotlib.pyplot as plt


#x = (0.7, -0.7, -1.9, 1.9, 6.8 ,-6.8,2.0,-2.0,6.5,-6.5,2.0,-2.0)
x = (1,2,3,4,5,6,7,8,9,10,11,12, 13,14)
y = ( -0.3243, -0.2863, -0.1098, -0.0502, -0.0193, 0.0492, 0.0687, 0.0791, 0.1139, 0.1166, 0.1953, 0.2383, 0.4452, 0.4469)
colors=( 'tab:red', 'tab:red', 'tab:red', 'tab:red', 'tab:blue','tab:blue', 'tab:red' , 'tab:blue', 'tab:blue','tab:red', 'tab:red', 'tab:blue', 'tab:blue','tab:blue')
e=( 'tab:blue', 'tab:blue', 'tab:blue', 'tab:red', 'tab:red','tab:blue', 'tab:red' , 'tab:blue', 'tab:red','tab:red', 'tab:red' , 'tab:blue', 'tab:red','tab:red')
labels = ("Hawley", "Braun" , "Scott","Cruz","Beto","Nelson","Blackburn ","McCaskel","Rosen","McSally","Heller", "Donnely" ,"Bredesen", "Sinema")

plt.scatter(x, y, c=colors, edgecolors=e)

i = 0

for i in range(14):
    plt.text(x[i], y[i] +.02, labels[i] , fontsize=9)

plt.show()
