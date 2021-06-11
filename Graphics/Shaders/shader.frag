#version 330 core

in vec2 Tex;

out vec4 Color;

uniform sampler2D tex;

void main()
{
    Color = texture(tex, Tex);
}