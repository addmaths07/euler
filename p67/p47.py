import math


height_of_tree = 0
mx = 0

def get_child_index(index):
	return index + (math.floor((1+math.sqrt(1+8*index))/2))



def get_left_parent_sum(data_tree, left_parent_index, number, level):
	#print 'L', level
	#print "L P I", left_parent_index
	if left_parent_index< 0:
		return number

	parent_level = get_node_level(left_parent_index) - 1
	#print 'L P L', parent_level
	if level == parent_level:
		return number
	elif (level - parent_level == 1 ):
		return number + data_tree[left_parent_index]['sum']
	else:
		return number

def get_right_parent_sum(data_tree, right_parent_Index, number, level):
	#print 'L', level
	#print "R P I", right_parent_Index
	if right_parent_Index< 0:
		return number

	parent_level = get_node_level(right_parent_Index) - 1
	#print 'R P L', parent_level
	if level == parent_level:
		return number
	elif (level - parent_level == 1 ):
		return number + data_tree[right_parent_Index]['sum']
	else:
		return number

def get_right_sibling(index):
	return

def get_node_level(index):
	return math.floor((1+math.sqrt(1+8*index))/2)

def process_tree_level(level):
	return
	#if data_tree[]

def compute2(file_name):
	data_tree = []
	in_max = 0
	with open(file_name) as f:
		index = 0
		level = 0
		for line in f:
			for number in line.split(" "):
				
				number = int(number.replace('\n', ''))
				#print 'index', index
				left_parent_sum = get_left_parent_sum(data_tree, index - (level + 1), number, level)
				right_parent_sum = get_right_parent_sum(data_tree, index - level, number, level)

				sm = (right_parent_sum if right_parent_sum>left_parent_sum else left_parent_sum)
				#print 'sm for', number, 'is', sm
				data_tree.append( {'value': number, 'sum': sm} )
				if (sm>in_max):
					in_max = sm
				index+=1
			level+=1

	print "Max is ", in_max
	return data_tree

def fill_data(file_name):
	tree = []
	with open(file_name) as f:
		index = 0
		level = 0
		for line in f:
			for number in line.split(" "):
				
				tree.append( {'value': int(number), 'sum': 0} )

				index+=1
			level+=1
	return tree

def triverse_tree(tree, index, sm, n):
	global mx
	parent_level = get_node_level(index)
	left_child_index = get_child_index(index)
	left_child_level = get_node_level(left_child_index)


	tree[index]['sum'] = tree[index]['value'] + sm

	if mx<tree[index]['sum']:
		mx = tree[index]['sum']

	if (left_child_level - parent_level == 1 and left_child_index<n):
		triverse_tree(tree, int(left_child_index), tree[index]['sum'], n)


	right_child_index = left_child_index+1
	right_child_level = get_node_level(right_child_index)

	if (right_child_level - parent_level == 1 and right_child_index<n):
		triverse_tree(tree, int(right_child_index), tree[index]['sum'], n)

	return

file_name = "p67_triangle.txt"
compute2(file_name)
"""
tree = fill_data(file_name)
triverse_tree(tree, 0, 0, len(tree))
print "Recursive Max is ", mx
"""

"""
for i in range(0, 8):
	print i, get_node_level(i)
"""

