import './styles.css';

function Input({ type, text, name, placeholder, handleOnChange, value }:any){

    return( 
        <div className='field'>
            <input 
            type={type} 
            name={name} 
            id={name}
            required
            placeholder={placeholder}
            onChange={handleOnChange}
            value={value}
            />
            <label className="label" htmlFor={name} title={name} data-title={name}></label>
        </div>
    );
}
export default Input;