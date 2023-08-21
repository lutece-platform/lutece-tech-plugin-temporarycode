/*
 * Copyright (c) 2002-2023, City of Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.temporarycode.service;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;

import fr.paris.lutece.plugins.temporarycode.business.EnumCharacterType;
import fr.paris.lutece.plugins.temporarycode.business.TemporaryCodeConfig;

/**
 * 
 * TemporaryCodeUtils
 *
 */
public class TemporaryCodeUtils
{
    
    /**
     * Private constructor
     */
    private TemporaryCodeUtils ( )
    {
        //Do nothing
    }
    
    /**
     * Generate code
     * @param config
     * @return the code generated
     */
    public static String generateCode( TemporaryCodeConfig config )
    {
        int length = config.getCodeLength( );      
        boolean useLetters = EnumCharacterType.ALPHANUMERIC.name( ).equals( config.getCharacterType( ) );
        boolean useNumbers = EnumCharacterType.NUMERIC.name( ).equals( config.getCharacterType( ) );
        
        return RandomStringUtils.random( length, useLetters, useNumbers ).toLowerCase( );      
    }
    
    /**
     * Add minute to date
     * @param config
     * @return timsestamp
     */
    public static Timestamp addMinuteToDate ( TemporaryCodeConfig config  )
    {
        Calendar c = Calendar.getInstance( );
        c.add( Calendar.MINUTE, + config.getValidityTime( ) );

        return new Timestamp( c.getTime( ).getTime( ) );
    }
     
}
