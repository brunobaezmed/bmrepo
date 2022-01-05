import React from 'react'
import ReactDom from 'react-dom'

import './index.css'
function BookList() {
  return (
    <section className='booklist'>
        {books.map((book,index) =>{
          const {img,title,author} = book;
          return <Book key={index} {...book}></Book>
        })}
    </section>
    );
}

const Book = (props) => {
  console.log(props);
  const clickHandler = (e) =>{
    console.log(e);
    console.log(e.target);
  }
  const complexExample = (author) =>{
    console.log(author);
  }
  const {img,title,author} = props;
  return (
         <article className='book' onMouseOver={()=>{
           console.log(author);
         }}>
         <img src={img} alt='' />
         <h1 onClick={() => console.log(title)}>{title}</h1>
         <h4>{author}</h4>
         <button type="button" onClick={clickHandler}>
           reference example
         </button>
         <button type="button" onClick={() =>complexExample(author)}> more complex example</button>
         </article>
      );
};
const books = [{
  id: 1,
  img: 'https://images-na.ssl-images-amazon.com/images/I/51rSSmdEUlL._SY344_BO1,204,203,200_.jpg'
  , title:'Operating Systems: Three Easy Pieces '
  ,author:'Remzi H Arpaci-Dusseau '
},
{
  id: 2,
  img: 'https://images-na.ssl-images-amazon.com/images/I/4186AAibrkL._SY291_BO1,204,203,200_QL40_FMwebp_.jpg'
  , title:'Structure and Interpretation of Computer Programs '
  ,author:' Harold Abelson  '
},
{
  id: 3,
  img: 'https://images-na.ssl-images-amazon.com/images/I/41T0iBxY8FL._SX440_BO1,204,203,200_.jpg'
  , title:'Introduction to Algorithms, 3rd Edition '
  ,author:'Thomas H. Cormen'
}];
const names = ['jhon','peter','susan']
const newNames = names.map((name)=>{
  return <h1>{name}</h1>
});
ReactDom.render(<BookList/>,document.getElementById('root')
);


