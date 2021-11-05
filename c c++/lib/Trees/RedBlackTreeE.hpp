#include "RedBlackTreeL.hpp"
template <typename type1,typename type2>
class RedBlackTreeE:public RedBlackTree < type1, type2> {
     struct Node
	{

		type1 key;
		type2 value;
		Node *left, *right, *root;
		color_t color = RED;
	};
     RedBlackTreeE() : root{
					 new Node[MAX_SIZE]},
				  iterator{0}
	{

		for (int i = 0; i < 9; ++i)
		{
			(root + i)->key = 0;

			(root + i)->left = nullptr;
			(root + i)->right = nullptr;
			(root + i)->root = nullptr;
		}
		size = 0;
		Tsz = 9;
	};

	RedBlackTreeE(int s) : root{
						 new Node[s]},
					  iterator{0}
	{
		for (int i = 0; i < s; ++i)
		{
			(root + i)->key = 0;
			(root + i)->left = nullptr;
			(root + i)->right = nullptr;
			(root + i)->root = nullptr;
		}
		Tsz = s;
		size = 0;
	};
     

	type1 replace(Node *n, Node *n2)
	{
		type1 key2 = n->key;
		type2 value2 = n->value;

		if (n2->key < key2)
		{

			while (n2->right != nullptr)
			{
				n2 = n2->right;
			}
			key2 = n2->key;
			value2 = n2->value;

			n->key = key2;
			n->value = value2;
			return delete_node(n2);
		}
		else
		{

			while (n2->left != nullptr)
			{
				n2 = n2->left;
			}
			key2 = n2->key;
			value2 = n2->value;

			n->key = key2;
			n->value = value2;
			return delete_node(n2);
		}
	}
	type1 delete_key(type1 key)
	{
		Node *troot = Treeroot();
		Node *node = getNode(troot, key);
		if (node->color == RED && node->left == nullptr && node->right == nullptr)
		{
			return delete_node(node);
		}
		if (node->left != nullptr || node->right != nullptr)
		{
			if (node->left != nullptr)
				 replace(node, node->left);
			else
				 replace(node, node->right);
			
		}
		if(node->color == BLACK) {
			if( node->left != nullptr && node->left->color == RED){

			}

		}
		return (type1)0;
	}
	type1 delete_node(Node *n)
	{
		Node *r = n->root;
		if (r->right == n)
		{
			r->right = nullptr;
		}
		else
		{
			r->left = nullptr;
		}
		type1 er = n->key;
		n->key = 0;
		size--;
		return er;
	}

	Node *bro(Node *n)
	{
		if (n == n->root->right)
			return n->root->left;
		else
			return n->root->right;
	}
};
