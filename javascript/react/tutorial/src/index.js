import React from 'react'
import ReactDom from 'react-dom'

import './index.css'
function BookList() {
  return (
    <section className='booklist'>
        {newNames}
    </section>
    );
}

const Book = (props) => {
  const {img,title,author} = props
  return (
         <article className='book'>
         <img src={img} alt='' />
         <h1>{title}</h1>
         <h4>{author}</h4>
         </article>
      );
};
const books = [{
  img: 'https://images-na.ssl-images-amazon.com/images/I/51rSSmdEUlL._SY344_BO1,204,203,200_.jpg'
  , title:'Operating Systems: Three Easy Pieces '
  ,author:'Remzi H Arpaci-Dusseau '
},
{
  img: 'https://images-na.ssl-images-amazon.com/images/I/4186AAibrkL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg'
  , title:'Structure and Interpretation of Computer Programs '
  ,author:' Harold Abelson  '
}];
const names = ['jhon','peter','susan']
const newNames = names.map((name)=>{
  return <h1>{name}</h1>
});
ReactDom.render(<BookList/>,document.getElementById('root')
);


